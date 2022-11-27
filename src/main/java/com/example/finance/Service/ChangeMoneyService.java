package com.example.finance.Service;

import com.example.finance.bean.ChangeMoney;
import com.example.finance.bean.FundProduct;
import com.example.finance.mapper.ChangeMoneyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChangeMoneyService {
    @Resource
    ChangeMoneyMapper changeMoneyMapper;

    public List<ChangeMoney> changeMoneyList() {
        List<ChangeMoney> changeMoneyList = changeMoneyMapper.selectList(null);
        return changeMoneyList;
    }
}
