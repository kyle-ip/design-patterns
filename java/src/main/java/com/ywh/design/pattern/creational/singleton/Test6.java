package com.ywh.design.pattern.creational.singleton;

/**
 * 饿汉模式
 */
public class Test6 {

    // 私有构造函数
    private Test6() {}

    // 单例对象（主要静态代码块执行顺序）
    private static Test6 instance;

    static {
        instance = new Test6();
    }

    // 静态的工厂方法
    public static Test6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
