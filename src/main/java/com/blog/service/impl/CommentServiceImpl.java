package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.dao.CommentMapper;
import com.blog.entity.Comment;
import com.blog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findCommentByBlogId(int id, int state) throws Exception {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<Comment>();
        queryWrapper.eq("blogId",id);//博客id
        queryWrapper.eq("state",state);//审核状态
        return commentMapper.selectList(queryWrapper);
    }

    @Override
    public int deleteCommentByBlogId(int blogId) throws Exception {
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<Comment>();
//        博客id，参数1是列名
        queryWrapper.eq("blogId",blogId);
        return commentMapper.delete(queryWrapper);
    }
}
