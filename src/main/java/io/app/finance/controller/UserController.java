package io.app.finance.controller;

import io.app.finance.dto.AuthenticationRequestDto;
import io.app.finance.dto.AuthenticationResponseDto;
import io.app.finance.dto.UserDto;
import io.app.finance.entity.UserEntity;
import io.app.finance.service.UserService;
import io.app.finance.service.impl.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public AuthenticationResponseDto createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticatioRequest) throws Exception {
        AuthenticationResponseDto authenticationResponse = authUserDetailsService.createAuthenticationToken(authenticatioRequest);
        return authenticationResponse;
    }

    @PostMapping
    public UserEntity createNewUser(@RequestBody UserDto user) {
        return this.userService.createNewUser(user);
    }
}
