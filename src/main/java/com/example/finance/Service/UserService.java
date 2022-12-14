package com.example.finance.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.finance.bean.User;
import com.example.finance.mapper.UserMapper;
import com.example.finance.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public JsonUtils login(String username, String password) {



        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);

        User user = userMapper.selectOne(wrapper);

         if (user == null) {
            return JsonUtils.fail();
        }
        JsonUtils success = JsonUtils.success();
        success.add("user", user);
        if (user.getRealname()!=null&&user.getRealname().equals("admin")) {
            //管理员
            success.add("url", "/admin/main.html");
            success.setCode(100);
            return success;
        }else{
            //普通用户
            success.add("url", "/user/main.html");
            success.setCode(100);
            return success;
        }

    }

    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    public JsonUtils verifyUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user=userMapper.selectOne(wrapper);
        if (user == null) {
            return JsonUtils.fail();
        }
        return JsonUtils.success();
    }

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    @Transactional
    public JsonUtils register(String username, String password,String repassword) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        wrapper.eq("username", username);
        if (StringUtils.isBlank(username)) {
            return JsonUtils.fail("用户名为空!");
        }
        if (StringUtils.isBlank(password)) {
            return JsonUtils.fail("密码为空!");
        }
        if (StringUtils.isBlank(repassword)) {
            return JsonUtils.fail("重复密码为空!");
        }
        if (userMapper.selectOne(wrapper) != null) {
            return JsonUtils.fail("用户名已存在!");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if (userMapper.insert(user) <1) {
            return JsonUtils.fail();
        }
        JsonUtils success = JsonUtils.success();
        success.add("url","/login.html");
        return success;
    }
}
