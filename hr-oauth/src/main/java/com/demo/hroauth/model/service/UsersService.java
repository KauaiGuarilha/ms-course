package com.demo.hroauth.model.service;

import com.demo.hroauth.model.client.users.UsersFeignClient;
import com.demo.hroauth.model.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UsersService implements UserDetailsService {

    @Autowired private UsersFeignClient usersFeignClient;

    public Users findByEmail(String email){
        Users users = usersFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(users)) throw new IllegalArgumentException("Email not found");

        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String usename) throws UsernameNotFoundException {
        Users users = usersFeignClient.findByEmail(usename).getBody();

        if (Objects.isNull(users)) throw new UsernameNotFoundException("Email not found");

        return users;
    }
}
