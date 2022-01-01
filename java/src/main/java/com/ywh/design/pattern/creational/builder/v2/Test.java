package com.ywh.design.pattern.creational.builder.v2;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * 建造者模式（链式调用，很实用）
 */
public class Test {
    public static void main(String[] args) {

        // 把建造者类封装在产品类中（静态内部类），（链式调用过程）每个建造方法都返回建造者本身，
        // 产品需要实现参数为建造者的构造方法，目的是（建造者）最终可以调用 build 返回产品。
        Course course = new Course.CourseBuilder()
            .buildCourseName("Java设计模式精讲")
            .buildCoursePPT("Java设计模式精讲PPT")
            .buildCourseVideo("Java设计模式精讲视频")
            .build();

        System.out.println(course);


        // Guava 库源码中的应用：XXXBuilder 调用 build 方法返回的都为 XXX
        Set<String> set = ImmutableSet.<String>builder()
            .add("a")
            .add("b")
            .build();
        System.out.println(set);

        // JDK 源码中的应用：StringBuilder
    }
}
