package com.ywh.design.pattern.creational.singleton;

/**
 * 单例模式（重点）：保证一个类仅有一个实例，并提供一个全局访问点（确保任何情况下都只有一个实例）；
 * 在内存仲只有一个实例，减少内存开销；
 * 可以避免对资源的多重占用；
 * 设置全局访问点，严格控制访问；
 * 没有接口，扩展困难；
 * 重点：私有构造器，线程安全，延迟加载，序列化与反序列化安全，反射
 * 组合：单例模式 + 工厂模式，单例模式 + 享元模式
 *
 * 饿汉模式：单例实例在类装载时进行创建
 * 如果对象创建有过多操作，会影响类加载，尤其该类没有被使用时会造成浪费
 */
public class Test2 {

    // 1. 私有构造函数
    private Test2() {}

    // 2. 单例对象（类装载即创建）
    private static Test2 instance = new Test2();

    // 3. 静态的工厂方法
    public static Test2 getInstance() {
        return instance;
    }
}
