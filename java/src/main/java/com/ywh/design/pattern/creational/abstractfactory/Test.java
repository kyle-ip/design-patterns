package com.ywh.design.pattern.creational.abstractfactory;

/**
 * 抽象工厂模式（重点）：关注产品族，提供创建一系列相关或依赖对象（产品族）的接口，无需指定具体的类；
 * 适用于客户端不依赖于产品类实例如何创建、实现等细节；
 * 强调一系列相关的产品对象（产品族）一起适用创建对象需要大量重复的代码；
 * 提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现；
 * 具体产品在应用层代码隔离，无需关心创建细节，而且可以将一系列的产品族统一创建；
 * 规定了所有可能被创建的产品集合，产品族中扩展新产品困难（修改抽象工厂接口），增加系统抽象性和理解难度。
 */
public class Test {
    public static void main(String[] args) {

        // Java 课程工厂继承自抽象课程工厂，可产生属于 Java 产品族的产品： 视频和手记（分别继承自对应的抽象产品）
        CourseFactory courseFactory = new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();

        // Mybatis 源码中的应用：

        // 抽象工厂 SqlSessionFactory
        // 具体工厂 DefaultSqlSessionFactory、SqlSessionManager
        // 产品族 SqlSession
    }
}
