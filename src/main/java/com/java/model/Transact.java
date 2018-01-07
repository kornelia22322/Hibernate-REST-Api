package com.java.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Transact {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int quantity;

    @ManyToMany(mappedBy = "transactionList", cascade = {CascadeType.ALL})
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
