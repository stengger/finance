package com.example.finance.bean;

import com.example.finance.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class MyInterceptor implements HandlerInterceptor {


        @Autowired
        private StringRedisTemplate redisTemplate;

        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


            HttpSession session=request.getSession();
            String username=(String) session.getAttribute("username");
            System.out.println(username);
            if (username == null) {
                //拦截未登录请求,跳转到登录页面
                response.sendRedirect("/login.html");
                return false;
            }
               return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

            }
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
            }
}

