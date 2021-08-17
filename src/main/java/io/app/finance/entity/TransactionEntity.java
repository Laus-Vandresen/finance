package io.app.finance.entity;

import io.app.finance.dto.TransactionDto;
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
    private String transactionType;
    private String category;
    private BigDecimal transactionAmount;

    public TransactionEntity(TransactionDto transactionDto) {
        this.userId = transactionDto.getUserId();
        this.accountId = transactionDto.getAccountId();
        this.description = transactionDto.getDescription();
        this.transactionType = transactionDto.getTransactionType();
        this.category = transactionDto.getCategory();
        this.transactionAmount = transactionDto.getTransactionAmount();
    }
}
