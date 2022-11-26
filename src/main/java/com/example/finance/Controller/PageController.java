package com.example.finance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("login.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("admin/main.html")
    public String adminMain() {
        return "/admin/main";
    }

    @RequestMapping("user/main.html")
    public String userMain() {
        return "/user/main";
    }
}
