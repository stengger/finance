package com.example.finance.Controller;

import com.example.finance.Service.UserService;
import com.example.finance.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("login")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("verifyLogin")
    public JsonUtils verifyLogin(String username,String password){
        return userService.login(username, password);
    }

    @RequestMapping("loginVerifyUsername/{username}")
    public JsonUtils loginVerifyUsername(@PathVariable String username) {
        JsonUtils jsonUtils = userService.verifyUsername(username);
        return jsonUtils;
    }
}