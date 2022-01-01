package com.ywh.design.pattern.behavioral.visitor;

/**
 * 访问者类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Visitor implements IVisitor {

    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程：" + freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程：" + codingCourse.getName() + "，价格：" + codingCourse.getPrice());
    }
}
