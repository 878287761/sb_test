package com.lilei.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.lilei.pojo.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.lilei.mapper.UserMapper;
import com.lilei.service.UserService;
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByModel(String username,String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",username).eq("password",password);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public User findById(String userId) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        User user = userMapper.selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(user)){
            user = new User();
        }
        return user;
    }
}
