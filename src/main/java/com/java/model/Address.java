package com.java.model;

public class Address {
    String street;
    int number;
    String code;
    String city;

    public Address() {
    }

    public Address(String street, int number, String code, String city) {
        this.street = street;
        this.number = number;
        this.code = code;
        this.city = city;
    }
}
