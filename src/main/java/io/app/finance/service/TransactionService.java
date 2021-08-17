package io.app.finance.service;

import io.app.finance.dto.TransactionDto;
import io.app.finance.entity.TransactionEntity;

public interface TransactionService {

    TransactionEntity createNewTransaction(TransactionDto transactionDto) throws Exception;
}
