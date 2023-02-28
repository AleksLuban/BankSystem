package com.javastart.bank;

import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;
import com.javastart.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

/**
 * Нужно написать приложение, которое будет создавать Account с параметрами пользователя
 * и счетом Bill
 * <p>
 * Так же нужно будет уметь принимать платежи Payment и пополнение счета Adjustment
 * <p>
 * И реализовать метод перевода денег с одного Account на другой (Transfer) в отдельном контроллере
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private AccountService accountService;

}
