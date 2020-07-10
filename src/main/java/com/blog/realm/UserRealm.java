package com.blog.realm;

import com.blog.entity.Blogger;
import com.blog.service.BloggerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * 用户自定义realm
 */
public class UserRealm extends AuthorizingRealm {

    @Resource
    private BloggerService bloggerService;

    /**
     * 验证权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     *验证身份（登录）
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        try {
//        得到当前用户名
            String userName = (String) token.getPrincipal();
//        调用根据用户名查询博主信息的方法
            Blogger blogger = bloggerService.findBloggerByUserName(userName);
//            对象不为空，表示存在此人，用户名验证通过
            if (blogger!=null){
//        创建验证身份对象
                AuthenticationInfo authenticationInfo = new
                        SimpleAuthenticationInfo(blogger.getUserName(),blogger.getPassword(),"");
                return authenticationInfo; //登陆成功
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        登陆失败
        return null;
    }
}
