package com.example.controller;


import com.example.dao.UserService;
import com.example.entity.*;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("1")
    public String c(){

        return "myPage";
    }
    @Autowired
    UserService sd;

    @RequestMapping(value = "login" ,method = RequestMethod.GET)
    public  String login(@Param("username")String username, @Param("password")String password, HttpServletRequest request){
        request.getParameter("username");
        return "login";
    }
    @RequestMapping("doLogin")
    @ResponseBody
    public JsonResult doLogin(
            boolean isRememberMe,
            String username,
            String password) {

        //1.封装用户信息
        UsernamePasswordToken token=
                new UsernamePasswordToken(username, password);
        if(isRememberMe) {
            token.setRememberMe(true);
        }
        //2.提交用户信息
        Subject subject=SecurityUtils.getSubject();
        subject.login(token);//token会提交给securityManager
        return new JsonResult("login ok");
    }
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login2(@Param("username") String username, @Param("password") String password) {
        ModelAndView m = new ModelAndView();
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken uToken = new UsernamePasswordToken(username, password);
        //实现记住我
        uToken.setRememberMe(true);
        try {
            //进行验证，报错返回首页，不报错到达成功页面。
            subject.login(uToken);

        } catch (UnknownAccountException e) {
            m.addObject("result", "用户不存在");
            m.setViewName("login");
            return m;
        } catch (IncorrectCredentialsException e) {
            m.addObject("result", "密码错误");
            m.setViewName("login");
            return m;
        }
        //将权限信息保存到session中
        User user = sd.querybyname(username);

        List<Permission> permissions = new ArrayList<Permission>();
        for (Role role : user.getRoles()) {
            for (Permission permission : role.getPermissions()) {
                permissions.add(permission);
            }
        }
        Map<String, ArrayList<Permission>> map = new HashMap<String, ArrayList<Permission>>();
        for (Permission p : permissions) {
            String name = p.getPermission_group_name();
            if (!map.containsKey(name)) {
                ArrayList<Permission> mList = new ArrayList<Permission>();
                mList.add(p);
                map.put(name, mList);
            } else {
                ArrayList<Permission> pList = map.get(name);
                pList.add(p);
                map.put(name, pList);
            }
        }
//       保存到shiro的session中一些信息
        Session session = subject.getSession();
//        保存userinfo的基本信息
        int uid = user.getUid();
        UserInfo userInfo = sd.queryuserinfo(uid);
        //保存user信息
        session.setAttribute("user", user);
//shiro权限验证成功后跳转的界面
        m.setViewName("index");
        return m;
    }

}
