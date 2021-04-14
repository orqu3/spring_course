package com.spring_course.lessons.lesson_2.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private double price;

 @Override
    public String toString() {
        return String.format("Product: id = %d, title = %s, coast = %.02f", id, name, price);
    }
}
