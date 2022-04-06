package com.lilei.service;

import com.lilei.pojo.User;

public interface UserService{


    User findByModel(String username,String password);

    User findById(String userId);
}
