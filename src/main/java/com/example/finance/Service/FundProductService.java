package com.example.finance.Service;

import com.example.finance.bean.FundProduct;
import com.example.finance.mapper.FundProductMapper;
import com.example.finance.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FundProductService {


    @Autowired
    FundProductMapper fundProductMapper;

    public List<FundProduct> fundProductList() {
        List<FundProduct> fundProductList = fundProductMapper.selectList(null);
        return fundProductList;
    }



    @Transactional
    public JsonUtils addFundProduct(FundProduct fundProduct) {
        int insert = fundProductMapper.insert(fundProduct);
        if (insert > 0) {
            return JsonUtils.success();
        }else{
            return JsonUtils.fail();
        }
    }
    /**
     * 增加功能
     * @return
     */

    @Transactional
    public JsonUtils deleteFundProductById(Integer id) {
        int myid = fundProductMapper.deleteById(id);
        if (myid > 0) {
            return JsonUtils.success();
        }else{
            return JsonUtils.fail();
        }
    }

    /**
     * 通过id获取基金产品信息
     * @param id
     * @return
     */
    public JsonUtils getFundProductInfoById(Integer id) {
        FundProduct fundProduct = fundProductMapper.selectById(id);
        JsonUtils success = JsonUtils.success();
        success.add("fundProduct", fundProduct);
        return success;
    }

    /**
     * 更新基金信息
     *
     * @param id
     * @param fundProduct
     * @return
     */
    @Transactional
    public JsonUtils updateFundProduct(Integer id, FundProduct fundProduct) {
        fundProduct.setId(id);
        if(fundProductMapper.updateById(fundProduct)>0){
            return JsonUtils.success();
        }else{
            return JsonUtils.fail();
        }
    }
}
