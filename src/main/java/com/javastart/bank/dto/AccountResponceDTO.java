package com.javastart.bank.dto;


import com.javastart.bank.entity.Account;
import com.javastart.bank.entity.Bill;

public class AccountResponceDTO {

    private Long id;

    private String email;

    private String phone;

    private Bill bill;

    public AccountResponceDTO(Long id, String email, String phone, Bill bill) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.bill = bill;
    }

    public AccountResponceDTO(Account account) {
        this.id = account.getId();
        this.email = account.getEmail();
        this.phone = account.getPhone();
        this.bill = account.getBill();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

}
