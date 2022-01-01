package com.ywh.design.pattern.structural.decorator.v2;

/**
 * 装饰者模式（重点）：在不改变原有对象的基础上附加新功能，提供了比继承更有弹性的替代方案；
 * 扩展一个类的功能或给一个类添加附加职责；
 * 动态地给一个对象添加功能，也可以动态撤销；
 * 装饰者时继承的有力补充，比继承灵活（动态的，而且不改变原有对象）；
 * 通过使用不同装饰类及这些类的排列组合实现不同效果，原有代码不用改变，符合开闭原则；
 * 会出现更多的类，增加代码复杂性，当动态装饰、多重装饰时会更复杂。
 * <p>
 * 对比：装饰者模式和代理模式，装饰者模式和适配器模式。
 */
public class Test {
    public static void main(String[] args) {
        // 在原始版本中，每一种组合都要创建一个实体类，代码无法重用
        // 使用装饰者模式，可以在购买煎饼的基础上动态添加鸡蛋和香肠，更灵活

        // 煎饼类和装饰者类都继承自抽象煎饼类，目的是无论如何组合装饰，对象都属于抽象煎饼类型
        // 需要扩展的部分则继承自装饰者类，并重写其核心的 cost、getDesc 方法实现装饰

        // 注意对象必须以抽象煎饼类声明
        ABattercake aBattercake;
        aBattercake = new Battercake();
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new EggDecorator(aBattercake);
        aBattercake = new SausageDecorator(aBattercake);

        System.out.println(aBattercake.getDesc() + " 销售价格:" + aBattercake.cost());

        // JDK 源码中的应用：InputStream
        // Servlet 源码中的应用：javax.servlet.ServletRequest
        // Mybatis 源码中的应用：org.apache.ibatis.cache.Cache
    }
}
