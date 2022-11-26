package com.example.finance.Controller;

import com.example.finance.Service.FundProductService;
import com.example.finance.bean.FundProduct;
import com.example.finance.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class FundProductControllre {
    @Resource
    private FundProductService fundProductService;

    @RequestMapping("/finance/toFundProduct.html")
    public String fundProductList(Model model) {
        List<FundProduct> fundProducts = fundProductService.fundProductList();
        model.addAttribute("foundProducts", fundProducts);
        return "/admin/finance/fundproduct";
    }

    @PostMapping("addFundProduct")
    @ResponseBody
    public JsonUtils addFundProduct(FundProduct fundProduct) {
        return fundProductService.addFundProduct(fundProduct);
    }

    @DeleteMapping("deleteFundProductById/{id}")
    @ResponseBody
    public JsonUtils deleteFundProductById(@PathVariable Integer id) {
        return fundProductService.deleteFundProductById(id);
    }

    @ResponseBody
    @GetMapping("getFundProductInfoById/{id}")
    public JsonUtils getFundProductInfoById(@PathVariable Integer id) {
        return fundProductService.getFundProductInfoById(id);
    }

    @ResponseBody
    @PutMapping("updateFundProduct/{id}")
    public JsonUtils updateFundProduct(@PathVariable Integer id,FundProduct fundProduct) {
        return fundProductService.updateFundProduct(id,fundProduct);
    }
}
