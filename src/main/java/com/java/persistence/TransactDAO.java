package com.java.persistence;

import com.java.model.Product;
import com.java.model.Transact;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TransactDAO {

    private Session session;

    public TransactDAO(Session session){
        this.session = session;
    }

    public Transact addTransact(List<Product> productList){
        Transaction tx = session.beginTransaction();

        Transact trans = new Transact();
        trans.setProductList(productList);
        session.save(trans);
        tx.commit();
        return trans;
    }
}
