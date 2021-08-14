package io.app.finance.service;


import io.app.finance.dto.AccountDto;
import io.app.finance.entity.AccountEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountService {

    AccountEntity createNewAccount(AccountDto account);
    List<AccountEntity> findAccountsByUserId(Long userId);
    AccountEntity editAccount(@RequestBody AccountDto accountDto, Long id) throws Exception;
    void deleteAccount(Long id);
}
