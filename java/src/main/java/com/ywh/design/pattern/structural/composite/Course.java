package com.ywh.design.pattern.structural.composite;

/**
 * 课程类
 */
public class Course extends CourseComponent {

    private String name;

    private double price;

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public double getPrice(CourseComponent courseComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course Name:" + name + " Price:" + price);
    }

}
