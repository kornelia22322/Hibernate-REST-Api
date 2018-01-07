package com.java.persistence;

import com.java.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ProductDAO {

    private Session session;

    public ProductDAO(Session session){
        this.session = session;
    }

    public List<Product> selectAll(){
        Transaction tx = session.beginTransaction();
        List<Product> results = session.createQuery("from Product as product" )
                .getResultList();

        tx.commit();
        return results;
    }

    public Product getById(int id){
        Transaction tx = session.beginTransaction();
        Product product = (Product) session.createQuery("from Product as product" +
                " where product.id = :id")
                .setParameter("id",id)
                .getSingleResult();

        tx.commit();
        return product;
    }
}
