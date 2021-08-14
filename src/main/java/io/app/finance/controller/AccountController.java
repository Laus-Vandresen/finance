package io.app.finance.controller;

import io.app.finance.dto.AccountDto;
import io.app.finance.entity.AccountEntity;
import io.app.finance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountEntity createNewAccount(@RequestBody AccountDto accountDto) {
        return this.accountService.createNewAccount(accountDto);
    }

    @GetMapping
    public List<AccountEntity> findAccountsByUserId(@RequestParam Long userId) {
        return accountService.findAccountsByUserId(userId);
    }

    @PutMapping("/{id}")
    public AccountEntity editAccount(@RequestBody AccountDto accountDto, @PathVariable Long id) throws Exception {
        return accountService.editAccount(accountDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

}
