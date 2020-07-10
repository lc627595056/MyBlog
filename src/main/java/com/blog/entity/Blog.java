package com.blog.entity;

import com.alibaba.fastjson.annotation.JSONField;
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
@TableName("t_blog")
public class Blog implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博客编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客摘要信息
     */
    private String summary;

    /**
     * 博客发布时间
     */
    @TableField("releaseDate")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;

    /**
     * 点击阅读量
     */
    @TableField("clickHit")
    private Integer clickHit;

    /**
     * 评论数量
     */
    @TableField("replyHit")
    private Integer replyHit;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 博客所属分类
     */
    @TableField("typeId")
    private Integer typeId;

    /**
     * 关键词
     */
    @TableField("keyWord")
    private String keyWord;

//    以下两个属性在数据库表中是不存在的，对应SQL语句中的别名
    @TableField(exist = false)
    private String releaseDateStr; //发布日期
    @TableField(exist = false)
    private String blogCount; //博客数量

//    博客类别，一对一
    @TableField(exist = false)
    private Blogtype blogtype;

//    博客内容，无html标签。获取博客内容的纯文本
    @TableField(exist = false)
    private String contentNoTag;

    public String getContentNoTag() {
        return contentNoTag;
    }

    public void setContentNoTag(String contentNoTag) {
        this.contentNoTag = contentNoTag;
    }

    public Blogtype getBlogtype() {
        return blogtype;
    }

    public void setBlogtype(Blogtype blogtype) {
        this.blogtype = blogtype;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public String getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(String blogCount) {
        this.blogCount = blogCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "Blog{" +
        "id=" + id +
        ", title=" + title +
        ", summary=" + summary +
        ", releaseDate=" + releaseDate +
        ", clickHit=" + clickHit +
        ", replyHit=" + replyHit +
        ", content=" + content +
        ", typeId=" + typeId +
        ", keyWord=" + keyWord +
        "}";
    }
}
