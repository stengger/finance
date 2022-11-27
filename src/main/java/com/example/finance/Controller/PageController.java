package com.example.finance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("index.html")
    public String indexPage() {
        return "login";
    }

    @RequestMapping("login.html")
    public String loginPage() {
        return "login";
    }

    @RequestMapping({"admin/main.html", "admin/index.html"})
    public String adminMain() {
        return "/admin/main";
    }

    @RequestMapping("user/main.html")
    public String userMain() {
        return "/user/main";
    }

    @RequestMapping("toregister.html")
    public String toregister() {
        return "register";
    }

    @RequestMapping("admin/userinfo/toUserInfo.html")
    public String toUserInfo() {
        return "/admin/userinfo/userinfo";
    }

    @RequestMapping("admin/userinfo/toBankCard.html")
    public String toBankCard() {
        return "admin/userinfo/bankcard";
    }

    @RequestMapping("admin/userinfo/toReputation.html")
    public String toReputation() {
        return "admin/userinfo/reputation";
    }

    @RequestMapping("admin/finance/toChangeMoney.html")
    public String toChangeMoney() {
        return "admin/finance/changemoney";
    }

    @RequestMapping("admin/finance/toTermFinancial.html")
    public String toTermFinancial() {
        return "admin/finance/termfinancial";
    }

    @RequestMapping("admin/finance/toBank.html")
    public String toBank() {
        return "admin/finance/bank";
    }

    @RequestMapping("admin/permission/toUserPermissions.html")
    public String toUserPermissions() {
        return "admin/permission/userpermissions";
    }

    @RequestMapping("admin/permission/toAdminPermissions.html")
    public String toAdminPermissions() {
        return "admin/permission/adminpermissions";
    }

    @RequestMapping("admin/loan/toLoanexam.html")
    public String toLoanexam() {
        return "admin/loan/loanexam";
    }

    @RequestMapping("admin/loan/toLoaninfo.html")
    public String toLoaninfo() {
        return "admin/loan/loaninfo";
    }
}
