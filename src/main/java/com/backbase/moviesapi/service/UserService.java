package com.backbase.moviesapi.service;

import com.backbase.moviesapi.entity.UserEntity;
import com.backbase.moviesapi.mapper.UserMapper;
import com.backbase.moviesapi.model.User;
import com.backbase.moviesapi.payload.LoginPayload;
import com.backbase.moviesapi.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;


    public User findUserFromLogin(String username) {
        return findUserByUsername(username)
                .map(userMapper::convertToModel)
                .orElse(null);
    }

    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findFirstByUsername(username);
    }

    public User saveUserFromLogin(LoginPayload loginPayload) {
        return Optional.of(createNewUserByUsername((loginPayload))
                ).map(userMapper::convertToModel)
                .orElse(null);
    }

    public UserEntity createNewUserByUsername(LoginPayload loginPayload) {
        var passwordEncoded = passwordEncoder.encode(loginPayload.getPassword());
        return userRepository
                .save(UserEntity.builder()
                        .username(loginPayload.getUsername())
                        .password(passwordEncoded)
                        .build());
    }


}
