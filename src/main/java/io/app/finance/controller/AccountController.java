package io.app.finance.controller;

import io.app.finance.dto.AccountDto;
import io.app.finance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountDto createNewAccount(@RequestBody AccountDto accountDto) {
        return new AccountDto(this.accountService.createNewAccount(accountDto));
    }

    @GetMapping
    public List<AccountDto> findAccountsByUserId(@RequestParam Long userId) {
        return accountService.findAccountsByUserId(userId).stream().map(AccountDto::new).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public AccountDto editAccount(@PathVariable Long id, @RequestBody AccountDto accountDto) throws Exception {
        return new AccountDto(accountService.editAccount(accountDto, id));
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
