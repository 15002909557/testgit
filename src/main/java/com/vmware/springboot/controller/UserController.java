package com.vmware.springboot.controller;

import com.vmware.springboot.modle.User;
import com.vmware.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/usercontroller")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public List<User> getUser(){
        List<User> users=userService.getUser();
        return users;
    }
}
