package com.ywh.design.pattern.creational.factorymethod;

/**
 * 工厂方法模式（重点）：关注产品等级结构，定义一个创建对象的接口，单让实现这个接口的类决定实例化哪个类（让类的实例化推迟到子类进行）
 * 创建对象需要大量重复的代码时适用（分为抽象工厂类、抽象产品类、工厂类、产品类）；
 * 客户端不依赖于产品类实例如何被创建、实现等细节（知道产品对应的工厂即可）；
 * 一个类通过其子类指定哪个对象（多态性，里氏替换原则），加入新产品符合开闭原则，提高可扩展性；
 * 类的个数容易过多（每添加一种产品都要添加相应的工厂），增加复杂度，同时增加了系统抽象性和理解难度。
 */
public class Test {
    public static void main(String[] args) {

        // Python 工厂（继承自抽象工厂）只生产（继承自抽象产品的） Python 视频
        VideoFactory videoFactory = new JavaVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();

        // JDK 源码中的应用：
        // Collection 的 iterator 相当于 VideoFactory 的 getVideo
        // ArrayList 相当于 JavaVideoFactory，产品为 Itr

        // 抽象工厂 URlStreamHandlerFactory
        // 具体工厂 Launcher.Factory
        // 抽象产品 URLStreamHandler
        // 具体产品 Handler

        // 抽象工厂 ILoggerFactory
        // 具体工厂 LoggerContext 等
        //
    }
}
