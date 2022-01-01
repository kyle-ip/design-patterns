package com.ywh.design.pattern.behavioral.visitor;

/**
 * 实战课程类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class CodingCourse extends Course {

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
