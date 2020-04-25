package com.vmware.springboot.service.impl;

import com.vmware.springboot.dao.UserMapper;
import com.vmware.springboot.modle.User;
import com.vmware.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private  UserMapper userMapper;

    public List<User> getUser(){
        List<User> users=userMapper.getUser();
        return users;
    };
}
