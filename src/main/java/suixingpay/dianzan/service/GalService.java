package suixingpay.dianzan.service;

import suixingpay.dianzan.bean.DianZan;

/**
 * @创建人 zhou_gc@suixingpay.com
 * @创建时间 2019/11/7 14:36
 * @描述
 */


public interface GalService {

    /**

     *@描述 保存点赞和评论

     *@参数

     *@返回值

     *@创建人  zhou_gc@suixingpay.com

     *@创建时间  2019/11/7

     *@修改人和其它信息

     */
    Object addStarAndComment(String userName, String content);

        /**

         *@描述  展示用户排名和评论

         *@参数

         *@返回值

         *@创建人  zhou_gc@suixingpay.com

         *@创建时间  2019/11/7

         *@修改人和其它信息

         */
    DianZan showSortAndComment();
}
