package io.app.finance.controller;

import io.app.finance.dto.AuthenticationRequestDto;
import io.app.finance.dto.AuthenticationResponseDto;
import io.app.finance.dto.UserDto;
import io.app.finance.service.UserService;
import io.app.finance.service.impl.AuthUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @PostMapping("/create-user")
    public void createNewUser(@RequestBody UserDto user) {
        this.userService.createNewUser(user);
    }
}
