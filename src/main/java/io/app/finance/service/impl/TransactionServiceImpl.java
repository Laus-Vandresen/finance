package io.app.finance.service.impl;

import io.app.finance.dto.TransactionDto;
import io.app.finance.entity.AccountEntity;
import io.app.finance.entity.TransactionEntity;
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
    public TransactionEntity createNewTransaction(TransactionDto transactionDto) throws Exception {
        Optional<AccountEntity> accountEntity = accountRepository.findById(transactionDto.getAccountId());
        if (!accountEntity.isPresent()) {
            throw new Exception("Account not found");
        }
        if ("E".equals(transactionDto.getTransactionType()) && transactionDto.getTransactionAmount().compareTo(accountEntity.get().getCurrentBalance()) > 0) {
            throw new Exception("Outgoing movement with a balance greater than the account balance");
        }
        recalculateAccountBalance(accountEntity.get(), transactionDto);
        return transactionRepository.save(new TransactionEntity(transactionDto));
    }

    private void recalculateAccountBalance(AccountEntity accountEntity, TransactionDto transactionDto) {
        if ("E".equals(transactionDto.getTransactionType())) {
            accountEntity.changeBalance(accountEntity.getCurrentBalance().subtract(transactionDto.getTransactionAmount()));
        } else {
            accountEntity.changeBalance(accountEntity.getCurrentBalance().add(transactionDto.getTransactionAmount()));
        }
        accountRepository.save(accountEntity);

    }
}
