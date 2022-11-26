package com.example.finance.config;

import com.example.finance.bean.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 将自定义拦截器作为bean写入配置
     * @return
     */
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截处理操作的匹配路径
        //放开静态拦截
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/user/**","/admin/**"); //拦截指定路径
//                .addPathPatterns("/**")//拦截所有路径
//                .excludePathPatterns("/bootstrap/**", "/images/**", "/js/**", "/layui/**", "/lyear/**")
//                .excludePathPatterns("/error/**","/user.html","/java/**")
//                .excludePathPatterns("/login.html", "/logout.html", "/index.html", "/register.html","/toregister.html");//排除路径


    }

}