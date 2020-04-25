package com.vmware.springboot.dao;

import com.vmware.springboot.modle.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> getUser();
}
