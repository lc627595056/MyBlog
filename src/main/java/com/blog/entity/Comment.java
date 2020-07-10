package com.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
@TableName("t_comment")
public class Comment implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 评论编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户IP地址
     */
    @TableField("userIp")
    private String userIp;

    /**
     * 所属博客id
     */
    @TableField("blogId")
    private Integer blogId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    @TableField("commentDate")
    private Date commentDate;

    /**
     * 审核状态1：待审核 2：已审核
     */
    private Integer state;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Comment{" +
        "id=" + id +
        ", userIp=" + userIp +
        ", blogId=" + blogId +
        ", content=" + content +
        ", commentDate=" + commentDate +
        ", state=" + state +
        "}";
    }
}
