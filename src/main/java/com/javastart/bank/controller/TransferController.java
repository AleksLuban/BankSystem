package com.javastart.bank.controller;

import com.javastart.bank.dto.TransferRequestDTO;
import com.javastart.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    private final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public String acceptTransfer(@RequestBody TransferRequestDTO transferRequestDTO) {
        return transferService.transferServ(transferRequestDTO.getSenderId(), transferRequestDTO.getRecipientId(), transferRequestDTO.getTransfer());
    }


}
