package io.app.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private String email;
    private String password;
    private String name;
    private String lastname;

    public void changePassword(String password) {
        this.password = password;
    }
}
