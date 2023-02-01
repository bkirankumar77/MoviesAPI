package com.backbase.moviesapi.service;

import com.backbase.moviesapi.config.PasswordConfig;
import com.backbase.moviesapi.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Order(2)
@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    private final PasswordConfig config;

    public JwtUserDetailsService(@Lazy UserService userService, @Lazy PasswordConfig config) {
        this.userService = userService;
        this.config = config;
    }

    public User loadUserByUsername(String username) {
        var userEntity = userService.findUserFromLogin(username);
        return User.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .password(config.encoder().encode(userEntity.getPassword()))
                .build();
    }


}
