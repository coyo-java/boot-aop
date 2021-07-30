package com.coyo.bootaop.service;


import com.coyo.bootaop.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User test(){
        return new User(1, "coyo", "蔡宇","12345",true);
    }
}
