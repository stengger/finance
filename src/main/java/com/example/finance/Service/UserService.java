package com.example.finance.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.finance.bean.User;
import com.example.finance.mapper.UserMapper;
import com.example.finance.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        if (user.getRealname().equals("admin")) {
            //管理员
            success.add("url", "/admin/main.html");
        }else{
            //普通用户
            success.add("url", "/user/main.html");
        }
        return success;
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
    public JsonUtils register(String username, String password) {

//        userMapper.insert();
        return JsonUtils.success();
    }
}
