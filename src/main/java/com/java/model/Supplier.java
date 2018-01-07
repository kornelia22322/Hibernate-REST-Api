package com.java.model;

import com.java.model.Product;

import javax.persistence.*;
import java.util.List;
import javax.persistence.JoinColumn;

@Entity
public class Supplier extends Company {

    private String accountNumber;

    public Supplier() {
    }

    public Supplier(String companyName, String street, int number, String code, String city, List<Product> products) {
        super(companyName, street, number, code, city, products);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}