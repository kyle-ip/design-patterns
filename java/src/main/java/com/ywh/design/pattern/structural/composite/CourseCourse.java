package com.ywh.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程分类类
 */
public class CourseCourse extends CourseComponent {

    private List<CourseComponent> items = new ArrayList<CourseComponent>();

    private String name;

    private Integer level;

    public CourseCourse(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void add(CourseComponent courseComponent) {
        items.add(courseComponent);
    }

    @Override
    public String getName(CourseComponent courseComponent) {
        return this.name;
    }

    @Override
    public void remove(CourseComponent courseComponent) {
        items.remove(courseComponent);
    }

    @Override
    public void print() {
        System.out.println(this.name);
        for (CourseComponent courseComponent : items) {
            if (this.level != null) {
                for (int i = 0; i < this.level; i++) {
                    System.out.print("  ");
                }
            }
            courseComponent.print();
        }
    }

}
