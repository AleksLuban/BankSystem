package com.javastart.bank.dto;


import com.javastart.bank.entity.Bill;

public class AccountRequestDTO {

    private String email;

    private String phone;

    private Bill bill;

    public AccountRequestDTO(String email, String phone, Bill bill) {
        this.email = email;
        this.phone = phone;
        this.bill = bill;
    }

    public AccountRequestDTO() {
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
