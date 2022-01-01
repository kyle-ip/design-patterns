package com.ywh.design.pattern.behavioral.visitor;

/**
 * 抽象课程类
 *
 * @author ywh
 * @since 2019/1/12
 */
public abstract class Course {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(IVisitor visitor);
}
