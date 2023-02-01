package com.backbase.moviesapi.controller;


import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.backbase.moviesapi.payload.LoginPayload;
import com.backbase.moviesapi.service.AuthService;
import com.backbase.moviesapi.service.UserService;
import io.swagger.annotations.Api;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
@RequiredArgsConstructor
@Api(value = "Login", tags = "Authentication")
public class AuthController {

    private static final String NAME_ATTRIBUT_TOKEN = "token";


    private final AuthService authService;
    private final UserService userService;


    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@Valid @RequestBody LoginPayload login) {
        var user = userService.findUserFromLogin(login.getUsername());
        if(Optional.ofNullable(user).isEmpty()) user = userService.saveUserFromLogin(login);
        String token = authService.login(user);
        return ResponseEntity.status(HttpStatus.OK)
                .header(NAME_ATTRIBUT_TOKEN, token)
                .contentType(APPLICATION_JSON)
                .body(user);
    }

}
