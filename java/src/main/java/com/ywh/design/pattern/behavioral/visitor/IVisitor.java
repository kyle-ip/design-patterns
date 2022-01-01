package com.ywh.design.pattern.behavioral.visitor;

/**
 * 访问者接口
 */
public interface IVisitor {

    void visit(FreeCourse freeCourse);

    void visit(CodingCourse codingCourse);

}
