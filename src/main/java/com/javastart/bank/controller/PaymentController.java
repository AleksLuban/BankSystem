package com.javastart.bank.controller;

import com.javastart.bank.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final AccountService accountService;

    public PaymentController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/accountsPay/{id}/{pay}")
    public String payment(@PathVariable Long id, @PathVariable Integer pay) {
        return accountService.payService(id, pay);
    }
}
