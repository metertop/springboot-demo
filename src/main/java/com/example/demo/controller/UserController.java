package com.example.demo.controller;

import com.example.demo.common.CommonResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by haoyuexun on 2018/7/5.
 */

@Controller
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(value = "username") String userName,
                          @RequestParam(value = "password") String passWd) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (Exception e) {
            logger.error("登录失败：{}", e.getMessage());
        }
        return "redirect:admin";
    }

    @GetMapping("/home")
    public String home() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.checkPermission("admin");
        } catch (UnauthorizedException e) {
            logger.error("没有足够的权限：{}", e.getMessage());
        }
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public CommonResponse Login(@RequestParam(value = "username") String userName,
                                @RequestParam(value = "password") String passWd){
        CommonResponse result = CommonResponse.createCommonResponse();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWd);
        User user = userService.selectByUserName(userName);
        result.setData(user);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            return CommonResponse.createFailResponse("10001", "登录失败！！");
        }

        return result;
    }

}
