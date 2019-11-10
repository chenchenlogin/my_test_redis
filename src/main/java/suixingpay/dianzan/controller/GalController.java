package suixingpay.dianzan.controller;

import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.*;
import suixingpay.dianzan.bean.DianZan;
import suixingpay.dianzan.service.GalService;
import suixingpay.dianzan.service.serviceimp.GalServiceImp;

/**
 * @创建人 zhou_gc@suixingpay.com
 * @创建时间 2019/11/7 14:49
 * @描述
 */

@CrossOrigin
@RestController
@RequestMapping("/gal")
public class GalController {
    @Autowired
    private GalService galService;

    /**
     * 添加用户点赞，添加用户评论
     *
     * @param userName
     * @param content
     * @return
     */
    @GetMapping("/save")
    public Object star(@RequestParam("userName") String userName, @RequestParam("content") String content) {
        return galService.addStarAndComment(userName, content);
    }

    /**
     * 查看排用户排名及评论
     *
     * @return
     */
    @GetMapping("/show")
    @ResponseBody
    public DianZan showNow() {


        DianZan dianZan= galService.showSortAndComment();

        for (Object contentList : dianZan.getContentLists()) {
            System.out.println(  contentList.toString());

        }

        /*for (ZSetOperations.TypedTuple<Object> sortSet : dianZan.getSortSets()) {
            System.out.println(sortSet.getValue()
            );
        }*/
        return  dianZan;
    }


}
