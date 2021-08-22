package io.app.finance.entity;

import io.app.finance.dto.TransactionDto;
import io.app.finance.enuns.AccountTypeEnum;
import io.app.finance.enuns.TransactionCategoryEnum;
import io.app.finance.enuns.TransactionTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "transactions")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long accountId;
    private String description;

    @Convert(converter = TransactionTypeEnum.Converter.class)
    private TransactionTypeEnum transactionType;

    @Convert(converter = TransactionCategoryEnum.Converter.class)
    private TransactionCategoryEnum category;

    private BigDecimal transactionAmount;

    public TransactionEntity(TransactionDto transactionDto) {
        this.id = transactionDto.getId();
        this.userId = transactionDto.getUserId();
        this.accountId = transactionDto.getAccountId();
        this.description = transactionDto.getDescription();
        this.transactionType = transactionDto.getTransactionType();
        this.category = transactionDto.getCategory();
        this.transactionAmount = transactionDto.getTransactionAmount();
    }
}
