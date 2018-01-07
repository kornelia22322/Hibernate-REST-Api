package com.java.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @SerializedName("Id")
    private int id;

    @SerializedName("productName")
    private String ProductName;

    @SerializedName("units")
    private int UnitsOnStock;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public List<Transact> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transact> transactionList) {
        this.transactionList = transactionList;
    }

    @ManyToMany
    private List<Transact> transactionList;

    public Product(){}

    public Product(String name, int Units, Category category){
        this.ProductName = name;
        this.UnitsOnStock = Units;
        this.category = category;
        this.transactionList = new LinkedList<Transact>(); {
        }
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public Category getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getUnitsOnStock() {
        return UnitsOnStock;
    }

    public void setUnitsOnStock(int unitsOnStock) {
        UnitsOnStock = unitsOnStock;
    }
}