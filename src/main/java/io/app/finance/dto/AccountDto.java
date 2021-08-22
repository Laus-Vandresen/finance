package io.app.finance.dto;

import io.app.finance.entity.AccountEntity;
import io.app.finance.enuns.AccountTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountDto {

    private Long id;
    private Long userId;
    private String name;
    private AccountTypeEnum type;
    private BigDecimal currentBalance;

    public AccountDto(AccountEntity entity) {
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.name = entity.getName();
        this.type = entity.getType();
        this.currentBalance = entity.getCurrentBalance();
    }
}
