package io.app.finance.entity;

import io.app.finance.dto.AccountDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String type;
    private BigDecimal currentBalance;

    public AccountEntity(AccountDto account) {
        this.userId = account.getUserId();
        this.name = account.getName();
        this.type = account.getType();
        this.currentBalance = account.getCurrentBalance();
    }

    public AccountEntity editAccount(AccountDto accountDto) {
        this.name = accountDto.getName();
        this.type = accountDto.getType();
        return this;
    }
}
