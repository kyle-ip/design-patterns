package com.ywh.design.pattern.creational.singleton;

/**
 * 懒汉模式：synchronized 同步
 */
public class Test3 {

    // 1. 私有构造函数
    private Test3() {}

    // 2. 单例对象
    private static Test3 instance = null;

    // 3. 静态的工厂方法（synchronized 确保同步，但由于该方法同一时刻只允许单线程访问，性能比较差）
    public static synchronized Test3 getInstance() {
        if (instance == null) {
            instance = new Test3();
        }
        return instance;
    }
}
