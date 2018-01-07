package com.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
@SecondaryTable(name = "ADDRESS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Company {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String CompanyName;

    @Column(table = "ADDRESS")
    private String street;

    @Column(table = "ADDRESS")
    private int number;

    @Column(table = "ADDRESS")
    private String code;

    @Column(table = "ADDRESS")
    private String city;


    @OneToMany(mappedBy = "supplier")
    private List<Product> products;

    public Company(String companyName, String street, int number, String code, String city, List<Product> products) {
        this.CompanyName = companyName;
        this.products = products;
        this.street = street;
        this.number = number;
        this.code = code;
        this.city = city;
    }

    public Company() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

}