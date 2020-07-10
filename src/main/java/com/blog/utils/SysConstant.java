package com.blog.utils;

/**
 * 系统常量接口
 */
public interface SysConstant {
    /**
     * 评论审核状态，1表示未审核，2表示已审核通过
     */
    int COMMENT_STATE_OK = 2;
    /**
     * 评论审核状态，1表示未审核，2表示已审核通过
     */
    int COMMENT_STATE_NO = 1;

    /**
     *  当前登陆用户的key
     */
    String LOGINUSER = "loginUser";

    /**
     * 博客类别名称和数量的缓存数据
     */
    String BLOG_NAME_COUNT = "blog_name_count";

    /**
     * 博客发布日期和数量的缓存
     */
    String BLOG_DATE_COUNT = "blog_date_count";


}
