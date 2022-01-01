package com.ywh.design.pattern.structural.composite;

/**
 * 课程分类组件类（包括课程类和课程目录类的所有方法，继承后选择性重写）
 */
public abstract class CourseComponent {

    public void add(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CourseComponent courseComponent) {
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print() {
        throw new UnsupportedOperationException("不支持打印操作");
    }

}
