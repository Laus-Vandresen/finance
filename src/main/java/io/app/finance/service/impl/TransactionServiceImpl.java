package io.app.finance.service.impl;

import io.app.finance.dto.TransactionDto;
import io.app.finance.entity.AccountEntity;
import io.app.finance.entity.TransactionEntity;
import io.app.finance.enuns.TransactionTypeEnum;
import io.app.finance.repository.AccountRepository;
import io.app.finance.repository.TransactionRepository;
import io.app.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionEntity createNewTransaction(TransactionDto transactionDto) throws RuntimeException {
        Optional<AccountEntity> accountEntity = accountRepository.findById(transactionDto.getAccountId());
        validateTransaction(accountEntity, transactionDto);
        recalculateAccountBalance(accountEntity.get(), transactionDto);
        return transactionRepository.save(new TransactionEntity(transactionDto));
    }

    private void recalculateAccountBalance(AccountEntity accountEntity, TransactionDto transactionDto) {
        if (TransactionTypeEnum.OUT.equals(transactionDto.getTransactionType())) {
            accountEntity.changeBalance(accountEntity.getCurrentBalance().subtract(transactionDto.getTransactionAmount()));
        } else {
            accountEntity.changeBalance(accountEntity.getCurrentBalance().add(transactionDto.getTransactionAmount()));
        }
        accountRepository.save(accountEntity);
    }

    private void validateTransaction(Optional<AccountEntity> accountEntity, TransactionDto transactionDto) {
        if (!accountEntity.isPresent()) {
            throw new RuntimeException("Account not found");
        }
        if (TransactionTypeEnum.OUT.equals(transactionDto.getTransactionType()) && transactionDto.getTransactionAmount().compareTo(accountEntity.get().getCurrentBalance()) > 0) {
            throw new RuntimeException("Outgoing movement with a balance greater than the account balance");
        }
    }
}
