package com.example.finance.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.finance.bean.FundProduct;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class UserFundProduct {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer userid;

    private Integer fundid;
   // @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date starttime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endtime;

    private FundProduct fundProduct;

    private Integer status;

    public UserFundProduct(Integer userid, Integer fundid, Date starttime, Date endtime, Integer status) {
        this.userid = userid;
        this.fundid = fundid;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
    }
}
