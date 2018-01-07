package com.java;

import com.java.controller.Controller;
import com.java.model.Category;
import com.java.model.Customer;
import com.java.model.Product;
import com.java.model.Supplier;
import com.java.persistence.TransactDAO;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final SessionFactory ourSessionFactory;
    static {
        try {

            Configuration configuration = new Configuration();
            configuration.configure();
            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) {


        final Session session = getSession();

        Category category_one = new Category("Dressess");
        Category category_two = new Category("Jewerly");
        Category category_three = new Category("Bags");

        Product product_one = new Product("Red Dress", 2, category_one);
        Product product_two = new Product("Black Dress", 3, category_one);

        Product product_three = new Product("Gold Necklage 5g", 3, category_one);
        Product product_four = new Product("Siver Bracelet 725", 2, category_two);

        Product product_five = new Product("MK Bag", 5, category_three);

        List<Product> list = new LinkedList<Product>();
        list.add(product_one);
        list.add(product_two);

        List<Product> list2 = new LinkedList<Product>();
        list2.add(product_three);
        list2.add(product_four);

        List<Product> list3 = new LinkedList<Product>();
        list3.add(product_five);

        category_one.setProductList(list);
        category_two.setProductList(list2);
        category_three.setProductList(list3);

        Supplier supplier = new Supplier("Malvaloca", "Reymonta", 13, "34-123", "Kraków", list);
        Supplier supplier2 = new Supplier("A&W S.C", "Długa", 135, "43-123", "Kraków", list2);
        Supplier supplier3 = new Supplier("Słoneczna", "Karmelicka", 23, "34-125", "Kraków", list3);
        Customer customer = new Customer("A&M Company", "Karmelicka", 23, "34-125", "Kraków", list3);
        Customer customer2 = new Customer("A&G Company", "Solakiewicza", 243, "34-125", "Kraków", list3);
        Customer customer3 = new Customer("T&D", "Miodowa", 233, "34-125", "Kraków", list3);


        product_one.setSupplier(supplier);
        product_two.setSupplier(supplier);
        product_three.setSupplier(supplier2);
        product_four.setSupplier(supplier2);
        product_five.setSupplier(supplier3);

        Transaction tx = session.beginTransaction();

        session.save(category_one);
        session.save(category_two);
        session.save(category_three);
        session.save(supplier);
        session.save(supplier2);
        session.save(supplier3);
        session.save(customer);
        session.save(customer2);
        session.save(customer3);

        tx.commit();

        TransactDAO transactDAO = new TransactDAO(session);
        transactDAO.addTransact(list);
        transactDAO.addTransact(list2);
        transactDAO.addTransact(list3);


   //     Product foundProduct = session.find(Product.class, 2);
   //    System.out.println("Supplier for product " + foundProduct.getProductName()
   //             + " is " + foundProduct.getSupplier().getCompanyName());

        Supplier foundSupplier = session.find(Supplier.class, 9);
        List<Product> foundList = foundSupplier.getProducts();
        for(Product product: foundList){
            System.out.println(product.getProductName());
        }


        session.close();



       // Controller home = new Controller();


    }
}