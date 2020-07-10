package com.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Blog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
public interface BlogService extends IService<Blog> {

    /**
     * 查询博客日期和博客数量
     * @return
     * @throws Exception
     */
    String findBlogDateAndCount() throws Exception;

    /**
     * 分页查询博客信息
     * @param page
     * @param blog
     * @return
     */
    IPage<Blog> findBlogByPage(IPage<Blog> page, Blog blog);

    Blog findBlogById(int id) throws Exception;

    /**
     * 查看上一篇博客
     * @param id
     * @return
     * @throws Exception
     */
    Blog findPrevBlog(int id) throws Exception;

    /**
     * 查看下一篇博客
     * @param id
     * @return
     * @throws Exception
     */
    Blog findNextBlog(int id) throws Exception;

    /**
     * 新增博客
     * @param blog
     * @return
     * @throws Exception
     */
    int addBlog(Blog blog) throws Exception;

    /**
     * 删除博客
     * @param blogId
     * @return
     * @throws Exception
     */
    int deleteBlogById(int blogId) throws Exception;

    /**
     * 修改博客
     * @param blog
     * @return
     * @throws Exception
     */
    int updateBlog(Blog blog) throws Exception;
}
