package io.app.finance.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionDto {

    private Long userId;
    private Long accountId;
    private String description;
    private String transactionType;
    private String category;
    private BigDecimal transactionAmount;
}
