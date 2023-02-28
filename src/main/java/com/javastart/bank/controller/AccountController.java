package com.javastart.bank.controller;

import com.javastart.bank.dto.AccountRequestDTO;
import com.javastart.bank.dto.AccountResponceDTO;
import com.javastart.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accounts")
    public Long createAccount( @RequestBody AccountRequestDTO accountRequestDTO) {
        return accountService.saveAccount(accountRequestDTO.getEmail(), accountRequestDTO.getPhone(), accountRequestDTO.getBill());
    }

    @GetMapping("/accounts/{accountId}")
    public AccountResponceDTO getAccount(@PathVariable Long accountId) {
        return new AccountResponceDTO(accountService.findAccount(accountId));
    }

    @DeleteMapping("/accounts/{accountId}")
    public AccountResponceDTO deleteAccount(@PathVariable Long accountId) {
        return new AccountResponceDTO(accountService.deleteAccount(accountId));
    }

}
