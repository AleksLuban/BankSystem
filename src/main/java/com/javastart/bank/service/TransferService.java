package com.javastart.bank.service;

import com.javastart.bank.entity.Account;

import com.javastart.bank.entity.Transfer;
import com.javastart.bank.exception.NotEnoughtMoneyException;
import com.javastart.bank.repository.AccountRepository;
import com.javastart.bank.repository.TransferRepository;
import org.hibernate.type.OffsetDateTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class TransferService {


    private final TransferRepository transferRepository;

    private final AccountService accountService;

    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository, AccountService accountService, AccountRepository accountRepository) {
        this.transferRepository = transferRepository;
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public String transferServ(Long senderId, Long recipientId, int trans) {
        Account accountSender = accountService.findAccount(senderId);
        Account accountRecipient = accountService.findAccount(recipientId);
        if (accountSender.getBill().getAmount() - trans > 0) {
            accountSender.getBill().setAmount(accountSender.getBill().getAmount() - trans);
            accountRepository.save(accountSender);
            accountRecipient.getBill().setAmount(accountRecipient.getBill().getAmount() + trans);
            accountRepository.save(accountRecipient);
            OffsetDateTime offsetDateTime = OffsetDateTime.now();
            Transfer transfer = new Transfer(senderId, recipientId, offsetDateTime.toString(), trans);
            transferRepository.save(transfer);
            return "success from " + accountSender.getId() + " to " + accountRecipient.getId();
        } else {
            throw new NotEnoughtMoneyException("money not enough");
        }
    }
}
