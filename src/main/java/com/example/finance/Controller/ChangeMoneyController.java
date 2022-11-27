package com.example.finance.Controller;

import com.example.finance.Service.ChangeMoneyService;
import com.example.finance.bean.ChangeMoney;
import com.example.finance.bean.FundProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("admin")
public class ChangeMoneyController {
    @Resource
    ChangeMoneyService changeMoneyService;

    @RequestMapping("finance/toChangeMoney.html")
    public String toChangeMoney(Model model) {
        List<ChangeMoney> changeMonies = changeMoneyService.changeMoneyList();
        model.addAttribute("changeMoneys", changeMonies);
        return "admin/finance/changemoney";
    }
}
