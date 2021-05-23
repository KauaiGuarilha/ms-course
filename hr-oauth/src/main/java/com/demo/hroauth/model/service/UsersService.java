package com.demo.hroauth.model.service;

import com.demo.hroauth.model.client.users.UsersFeignClient;
import com.demo.hroauth.model.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService {
    @Autowired private UsersFeignClient usersFeignClient;

    public Users findByEmail(String email){
        Users users = usersFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(users)) throw new IllegalArgumentException("Email not found");

        return users;
    }
}
