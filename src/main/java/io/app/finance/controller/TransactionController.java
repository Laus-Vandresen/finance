package io.app.finance.controller;

import io.app.finance.dto.TransactionDto;
import io.app.finance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public TransactionDto createNewTransaction(@RequestBody TransactionDto transactionDto) throws RuntimeException {
        return new TransactionDto(transactionService.createNewTransaction(transactionDto));
    }
}
