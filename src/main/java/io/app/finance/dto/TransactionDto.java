package io.app.finance.dto;

import io.app.finance.entity.TransactionEntity;
import io.app.finance.enuns.TransactionCategoryEnum;
import io.app.finance.enuns.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TransactionDto {

    private Long id;
    private Long userId;
    private Long accountId;
    private String description;
    private TransactionTypeEnum transactionType;
    private TransactionCategoryEnum category;
    private BigDecimal transactionAmount;

    public TransactionDto(TransactionEntity transactionEntity) {
        this.id = transactionEntity.getId();
        this.userId = transactionEntity.getUserId();
        this.accountId = transactionEntity.getAccountId();
        this.description = transactionEntity.getDescription();
        this.transactionType = transactionEntity.getTransactionType();
        this.category = transactionEntity.getCategory();
        this.transactionAmount = transactionEntity.getTransactionAmount();
    }
}
