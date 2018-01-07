package com.java.controller;

import com.java.model.Product;
import com.java.model.Transact;
import com.java.persistence.ProductDAO;
import com.java.persistence.TransactDAO;
import org.hibernate.Session;

import java.util.LinkedList;
import java.util.List;

import static com.java.Main.getSession;
import static com.java.util.JsonUtil.json;
import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.SparkBase.port;

public class Controller {
    public Controller(){
        port(8080);
        Order order = new Order();

        get("/", (request, response) -> {
            Session session = getSession();
            ProductDAO productDAO = new ProductDAO(session);
            List<Product> list = productDAO.selectAll();
            session.close();
            return list;
            }, json());
        post("/add/:id", (request, response) -> {
            Session session = getSession();
            int id = Integer.parseInt(request.params(":id"));
            ProductDAO productDAO = new ProductDAO(session);
            Product product = productDAO.getById(id);
            order.addtoList(product);
            System.out.println(product.getProductName());
            session.close();
            return "";
        });
        post("/order", (request, response) -> {
            Session session = getSession();
            if(order.getProductList().isEmpty()) {
                response.redirect("/error", 404);
            }
            else {
                TransactDAO transactDAO = new TransactDAO(session);
                Transact transact = transactDAO.addTransact(order.getProductList());
                for(Product product: transact.getProductList()){
                    System.out.println(product.getProductName());
                }
                order.setProductList(new LinkedList<Product>());
                response.redirect("/success", 200);
            }
            session.close();
            return "";
        });
        get("/error", (request, response) -> {
            response.body("Placing your order failed");
            return "";
        }, json());
        get("success", (request, response) -> {
            response.body("Placing your order succedded. Thank You!");
            return "";
        }, json());

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
