package io.app.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountDto {

    private Long userId;
    private String name;
    private String type;
    private BigDecimal currentBalance;
}
