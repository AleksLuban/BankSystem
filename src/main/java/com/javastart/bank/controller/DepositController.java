package com.javastart.bank.controller;

import com.javastart.bank.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    private final AccountService accountService;

    public DepositController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accountsDep/{id}/{dep}")
    public String deposit(@PathVariable Long id, @PathVariable Integer dep) {
        return  accountService.depService(id,dep);
    }
}
