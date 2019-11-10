package suixingpay.dianzan.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;

/**
 * @创建人 zhou_gc@suixingpay.com
 * @创建时间 2019/11/7 14:33
 * @描述
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
@Builder
public class DianZan {

    private Set<ZSetOperations.TypedTuple<Object>> sortSets;

    private List<Object> contentLists;

}
