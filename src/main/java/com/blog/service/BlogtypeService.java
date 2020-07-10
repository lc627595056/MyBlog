package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Blogtype;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
public interface BlogtypeService extends IService<Blogtype> {

    /**
     * 查询每个博客分类下的博客名称及博客数量
     * @return
     * @throws Exception
     */
    String getBlogTypeNameAndBlogCount() throws Exception;
}
