package com.blog.service;

import com.blog.entity.Blogger;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
public interface BloggerService extends IService<Blogger> {

    /**
     * 根据博主名称查询博主的信息
     * @param username
     * @return
     * @throws Exception
     */
    Blogger findBloggerByUserName(String username) throws Exception;
}
