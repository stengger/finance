package com.example.finance.Controller;
import com.alibaba.fastjson.JSON;
import com.example.finance.Service.UserService;
import com.example.finance.utils.JsonUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class UserController {
    @Resource
    public UserService userService;


    @RequestMapping("/verifyLogin")
    public JsonUtils verifyLogin(String username,String password,HttpServletRequest request){
        JsonUtils jsonUtils  = userService.login(username, password);
        if(jsonUtils.getCode() == 100){
            request.getSession().setAttribute("username",username);
        }
        return jsonUtils;
    }


    //获取用户名
    @RequestMapping("/loginVerifyUsername/{username}")
    public JsonUtils loginVerifyUsername(@PathVariable String username) {
        JsonUtils jsonUtils = userService.verifyUsername(username);
        return jsonUtils;
    }

    @PostMapping("/register")
    public JsonUtils register(String username, String password,String repassword) {
        JsonUtils jsonUtils = userService.register(username, password,repassword);
        return jsonUtils;
    }


}
