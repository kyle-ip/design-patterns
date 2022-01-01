package com.ywh.design.pattern.behavioral.templatemethod;

/**
 * 模板方法模式（重点）：定义一个算法股价，允许子类为一或多个步骤提供实现，使得子类在不改变算法结构的情况下重新定义算法某些步骤；
 * 一次性实现一个算法不变的部分，将可变的行为留给子类实现，通过对子类的扩展增加新行为，提高扩展性；
 * 各子类中公共的行为被提取出来并集中到一个公共父类中，提高代码复用性，符合开闭原则；
 * 类的个数增加，增加了系统实现的复杂度；
 * 由于要通过继承实现，如果父类添加新的抽象方法，所有子类都要修改；
 * 钩子方法：提供缺省行为，供子类在必要时扩展；
 * 对比：模板方法模式和工厂方法模式、模板方法模式和策略模式。
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println("后端设计模式课程start---");
//        ACourse designPatternCourse = new DesignPatternCourse();
//        designPatternCourse.makeCourse();
//        System.out.println("后端设计模式课程end---");

        System.out.println("前端课程start---");
        ACourse feCourse = new FECourse(false);
        feCourse.makeCourse();
        System.out.println("前端课程end---");

        // 在 JDK 源码中的应用：AbstractList（模板方法 addAll 、抽象方法 get）、HttpServlet（doGet、Service）
        // 在 Mybatis 源码中的应用：BaseExecutor

    }
}
