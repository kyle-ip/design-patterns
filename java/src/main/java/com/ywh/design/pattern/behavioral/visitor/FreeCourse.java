package com.ywh.design.pattern.behavioral.visitor;

/**
 * 免费课程类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class FreeCourse extends Course {

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
