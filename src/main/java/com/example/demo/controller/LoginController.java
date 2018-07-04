package com.example.demo.controller;

import com.example.demo.dto.ResponseResult;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 *
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/doLogin")
    public ResponseResult doLogin(String username, String password) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        User user = userService.selectByUserName(username);

        ResponseResult result = new ResponseResult(10000, "登录成功", user);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            result.setCode(10000);
            result.setMsg("登录失败！");
            result.setData(null);
        }
        return result;
    }
}
