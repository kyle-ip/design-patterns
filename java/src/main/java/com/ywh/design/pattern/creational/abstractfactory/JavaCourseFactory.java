package com.ywh.design.pattern.creational.abstractfactory;

/**
 * Java 课程工厂类
 */
public class JavaCourseFactory implements CourseFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
