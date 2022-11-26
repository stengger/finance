package com.example.finance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LogoutController {
    @RequestMapping("logout")
    public String logout(String logout) {
        return "login";
    }


}
