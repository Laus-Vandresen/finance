package io.app.finance.entity;

import io.app.finance.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    private String lastname;

    public UserEntity(UserDto user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastname = user.getLastname();
    }
}
