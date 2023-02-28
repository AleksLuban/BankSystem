package com.javastart.bank.service;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.exception.AccountNotFoundException;
import com.javastart.bank.exception.NotEnoughtMoneyException;
import com.javastart.bank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long saveAccount(String name, String email, Bill bill) {
        Account account = new Account(name, email, bill);
        return accountRepository.save(account).getId();
    }

    public Account findAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Can't find account with id " + id));
    }

    public Account deleteAccount(Long accountId) {

        Account deletedAccount = findAccount(accountId);
        accountRepository.deleteById(accountId);
        return deletedAccount;
    }

    @Transactional
    public String payService(Long id, Integer pay) {
        Account account = findAccount(id);

        if (account.getBill().getAmount() - pay > 0) {
            account.getBill().setAmount(account.getBill().getAmount() - pay);
            accountRepository.save(account);
            return "success: " + account.getId();
        } else {
            throw new NotEnoughtMoneyException("money is not enough");
        }
    }


    @Transactional
    public String depService(Long id, Integer pay) {
        Account account = findAccount(id);
        account.getBill().setAmount(account.getBill().getAmount() + pay);
        accountRepository.save(account);
        return "success " + account.getId();
    }
}