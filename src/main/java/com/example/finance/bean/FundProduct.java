package com.example.finance.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class FundProduct {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer type;

    private Integer code;

    private String funddesc;

    private BigDecimal dailygrowth;

    private BigDecimal leastmoney;

    private BigDecimal profit;

    private String investerm;
}
