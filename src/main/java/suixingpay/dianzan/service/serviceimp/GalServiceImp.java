package suixingpay.dianzan.service.serviceimp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import suixingpay.dianzan.bean.DianZan;
import suixingpay.dianzan.service.GalService;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @创建人 zhou_gc@suixingpay.com
 * @创建时间 2019/11/7 14:40
 * @描述
 */

@Slf4j
@Service
public class GalServiceImp implements GalService {

    // 用户排名
    private static final String USER_SORT = "star:sort";
    // 用户评论
    private static final String USER_COMMENTS = "star:comments";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Object addStarAndComment(String userName, String content) {
        try {
            System.out.println("用户"+userName+"开始点赞");

             final int num = 1;
            String description = "用户[" + userName + "]点赞并发表评论[" + content + "]";
            Long result = redisTemplate.opsForList().leftPush(USER_COMMENTS, description);
            if (result!=null&&result>0){
                Double score=redisTemplate.opsForZSet().incrementScore(USER_SORT, userName, num);

                if (null != score && score > 0) {
                    System.out.println("用户"+userName+"点赞成功");
                    //只有点赞成功后才裁剪list
                    redisTemplate.opsForList().trim(USER_COMMENTS, 0, 19);
                     return "SUCCESS";

                } else {
                    redisTemplate.opsForList().leftPop(USER_COMMENTS);
                    redisTemplate.opsForZSet().incrementScore(USER_SORT, userName, -1);
                    System.out.println("用户"+userName+"点赞失败");
                    return "FALSE";
                }

            }else {
                 redisTemplate.opsForList().leftPop(USER_COMMENTS);
                System.out.println("用户"+userName+"点赞失败");
                 return "FALSE";
            }

        } catch (Exception e) {
            System.out.println("用户"+userName+"点赞失败");
            return "FALSE";
        }
    }


    @Override
    public DianZan showSortAndComment() {
        // 取前20个用户评论
        List<Object> list = redisTemplate.opsForList().range(USER_COMMENTS, 0, 19);
        // 取前20个用户排名
        Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().reverseRangeWithScores(USER_SORT, 0, 19);
        return DianZan.builder().sortSets(tuples).contentLists(list).build();
    }
}
