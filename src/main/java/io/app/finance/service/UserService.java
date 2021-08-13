package io.app.finance.service;

import io.app.finance.dto.UserDto;
import io.app.finance.entity.UserEntity;


public interface UserService {

    UserEntity findUserByEmail(String email);
    UserEntity createNewUser(UserDto usuario);
}
