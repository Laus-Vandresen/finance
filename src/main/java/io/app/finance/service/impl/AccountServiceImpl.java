package io.app.finance.service.impl;

import io.app.finance.dto.AccountDto;
import io.app.finance.entity.AccountEntity;
import io.app.finance.repository.AccountRepository;
import io.app.finance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountEntity createNewAccount(AccountDto account) {
        return accountRepository.save(new AccountEntity(account));
    }

    @Override
    public List<AccountEntity> findAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public AccountEntity editAccount(AccountDto accountDto, Long id) throws Exception {
        AccountEntity accountEntity = accountRepository.findById(id).get();
        if (Objects.isNull(accountEntity)) {
            throw new Exception("Account not found");
        }
        return accountRepository.save(accountEntity.editAccount(accountDto));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
