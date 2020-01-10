package com.example.shiro;


import com.example.dao.UserService;
import com.example.entity.Permission;
import com.example.entity.Role;
import com.example.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    Boolean cachingEnabled=true;

    @Autowired
    UserService us;

    //角色权限和对应权限添加
    //Authorization授权，将数据库中的角色和权限授权给输入的用户名

    //用户身份验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token获取用户名,从主体传过来的认证信息中获取
        //加这一步的目的是在post请求时会先进入认证然后再到请求。
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        if (authenticationToken.getPrincipal() == null) {
            System.out.println(11);
            return null;
        }
        //获取用户的登录信息，用户名
        String phone = authenticationToken.getPrincipal().toString();

        //根据service调用用户名，查找用户的全部信息
        //通过用户名到数据库获取凭证
        User user = us.querybyname(phone);
        System.out.println(12);

        if (user == null) {
            //这里返回会报出对应异常
            System.out.println(1);
            return null;
        } else {
            System.out.println(13);
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(phone, user.getUpwd().toString(), getName());
            System.out.println(2);
            System.out.println(simpleAuthenticationInfo.toString());
            return simpleAuthenticationInfo;
        }

    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录的用户名
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        System.out.println(10);
        String phone = (String) principalCollection.getPrimaryPrincipal();
        //到数据库里查询要授权的内容
        User user = us.querybyname(phone);
        //记录用户的所有角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();//权限信息
        for (Role r : user.getRoles()) {
            //将所有的角色信息添加进来。

            simpleAuthorizationInfo.addRole(r.getRname());
            for (Permission p : r.getPermissions()) {
                //将此次遍历到的角色的所有权限拿到，添加·进来
                simpleAuthorizationInfo.addStringPermission(p.getPname());
            }
        }
        return simpleAuthorizationInfo;
    }

}