package io.app.finance.service.impl;

import io.app.finance.dto.UserDto;
import io.app.finance.entity.UserEntity;
import io.app.finance.repository.UserRepository;
import io.app.finance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity createNewUser(UserDto user) {
        user.changePassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(new UserEntity(user));
    }
}
