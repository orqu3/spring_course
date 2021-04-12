package com.spring_course.lessons.lesson_2;

/*
1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>,
    при старте в него нужно добавить 5 любых товаров.
2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart, в который можно добавлять
    и удалять товары по id.
3. Написать консольное приложение, позволяющее управлять корзиной.
4. При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

import com.spring_course.lessons.lesson_2.beans.Basket;
import com.spring_course.lessons.lesson_2.product_app_config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ProductApp {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    private static final Basket basket = context.getBean(Basket.class);

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> printInstructions();
                case 1 -> basket.printProductList();
                case 2 -> basket.addProduct();
                case 3 -> basket.removeProduct();
                case 4 -> quit = true;
                default -> throw new IllegalArgumentException("Unexpected value: " + choice + ". Please, try again.");
            }
        }
    }

    public static void printInstructions() {
        System.out.println("Hello! Welcome to our grocery basket generator. Please follow the instructions!");
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of products in your basket.");
        System.out.println("\t 2 - To add a product to the basket from product repository.");
        System.out.println("\t 3 - To remove a product from the basket.");
        System.out.println("\t 4 - To quit the application.");
    }
}
