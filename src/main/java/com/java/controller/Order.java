package com.java.controller;

import com.java.model.Product;

import java.util.LinkedList;
import java.util.List;

public class Order {
    private List<Product> productList;

    public Order(){
        productList = new LinkedList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addtoList(Product product) {
        productList.add(product);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
