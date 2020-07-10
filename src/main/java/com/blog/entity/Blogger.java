package com.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ：LiuQingchuang
 * @since 2020-07-02
 */
@TableName("t_blogger")
public class Blogger implements Serializable {

private static final long serialVersionUID=1L;

    /**
     * 博主编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 个人简介
     */
    private String profile;

    /**
     * 昵称
     */
    @TableField("nickName")
    private String nickName;

    /**
     * 座右铭
     */
    private String sign;

    /**
     * 博主头像
     */
    @TableField("imageName")
    private String imageName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Blogger{" +
        "id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", profile=" + profile +
        ", nickName=" + nickName +
        ", sign=" + sign +
        ", imageName=" + imageName +
        "}";
    }
}
