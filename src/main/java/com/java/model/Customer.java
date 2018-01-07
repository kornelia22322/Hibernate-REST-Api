package com.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer extends Company {

    double discount;

    public Customer() {
    }

    public Customer(String companyName, String street, int number, String code, String city, List<Product> products) {
        super(companyName, street, number, code, city, products);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
