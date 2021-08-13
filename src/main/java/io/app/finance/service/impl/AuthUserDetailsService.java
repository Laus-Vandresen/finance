package io.app.finance.service.impl;

import io.app.finance.config.AuthenticationUserDetails;
import io.app.finance.dto.AuthenticationRequestDto;
import io.app.finance.dto.AuthenticationResponseDto;
import io.app.finance.entity.UserEntity;
import io.app.finance.service.UserService;
import io.app.finance.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findUserByEmail(userName);
        if (Objects.isNull(userEntity)) {
            throw new UsernameNotFoundException("User details not found for the user : " + userName);
        }
        return new AuthenticationUserDetails(userEntity);
    }

    public AuthenticationResponseDto createAuthenticationToken(AuthenticationRequestDto authenticatioRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticatioRequest.getEmail(), authenticatioRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = loadUserByUsername(authenticatioRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return new AuthenticationResponseDto(jwt);
    }

}
