package com.spring_course.lessons.lesson_2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Basket {

    private final ProductRepository productRepository;
    private final List<Product> basket = new ArrayList<>();
    private final Random random = new Random();

    @Value("5")
    private int listSize;

    public Basket(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct() {
        int id = random.nextInt(listSize) + 1;
        basket.add(productRepository.getProductById(id));
    }

    public void removeProduct() {
        int id = random.nextInt(listSize) + 1;
        basket.remove(productRepository.getProductById(id));
    }

    public void printProductList() {
        System.out.println("You have " + basket.size() + " items in your basket");
        for (Product product : basket) {
            System.out.println(product);
        }
    }
}