package com.spring_course.lessons.lesson_2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {

    @Value("5")
    private int listSize;
    private List<Product> productList;
    private final Random random = new Random();

    @PostConstruct
    private void generate() {
        productList = new ArrayList<>();
        for (int i = 1; i <= listSize; i++) {
            double price = random.nextDouble() * 100;
            productList.add(new Product(i, "product " + i, price));
        }
    }

    public List<Product> getListOfAllProducts() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProductById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}