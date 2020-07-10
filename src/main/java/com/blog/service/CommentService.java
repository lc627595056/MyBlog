package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.entity.Comment;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
public interface CommentService extends IService<Comment> {
    /**
     * 根据博客id查询该博客下的评论列表
     * @param id
     * @param state
     * @return
     * @throws Exception
     */
    List<Comment> findCommentByBlogId(int id, int state) throws Exception;

    /**
     * 根据博客id删除评论
     * @param blogId
     * @return
     * @throws Exception
     */
    int deleteCommentByBlogId(int blogId) throws Exception;

}
