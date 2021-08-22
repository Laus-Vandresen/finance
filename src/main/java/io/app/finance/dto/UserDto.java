package io.app.finance.dto;

import io.app.finance.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String lastname;

    public void changePassword(String password) {
        this.password = password;
    }

    public UserDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
        this.name = userEntity.getName();
        this.lastname = userEntity.getLastname();
    }
}
