package com.example.finance.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j   //lombok 日志注解
public class MybatisPlusConfig {

    //很多框架的配置 信息在springboot中是以配置类的形式出现
    //它将所需的配置信息写到类里面去 这些类大家不用会写 要求看的懂有印象会用就ok类

    /**
     * 插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean
    public MetaObjectHandler getMetaObjectHandler(){
        return  new MetaObjectHandler(){
            //指定mybatis plus在执行插入语句的时候 执行 创建获取当前时间 然后赋值到对应的属性字段中
            //这里是一个统一的配置写法 当我们插入修改时间 或者创建时间的记录的时候
            //这里就会默认帮我们指定好了
            @Override
            public void insertFill(MetaObject metaObject) {
                //lombok生成的 日志对象 可以查看编译后代码得到
                log.info("start insert fill ....");
                this.setFieldValByName("createTime", new Date(), metaObject);
                this.setFieldValByName("updateTime", new Date(), metaObject);
                //给控制乐观锁 的字段赋予初始值
                this.setFieldValByName("version", 1, metaObject);
            }
            @Override
            public void updateFill(MetaObject metaObject) {
                log.info("start update fill ....");
                this.setFieldValByName("updateTime", new Date(), metaObject);
            }
        };
    }
}