package com.ywh.design.pattern.creational.singleton.notthreadsafe;

/**
 * （非线程安全）懒汉模式：单例实例在第一次使用时进行创建
 */
public class Test1 {

    // 1. 私有构造函数
    private Test1() {
    }

    // 2. 单例对象
    private static Test1 instance = null;

    // 3. 静态的工厂方法
    public static Test1 getInstance() {

        // 多个线程同时对 instance 进行判断时，可能因为都取到 null 值而都进行初始化，从而获取到不同的实例
        if (instance == null) {
            instance = new Test1();
        }
        return instance;
    }
}
