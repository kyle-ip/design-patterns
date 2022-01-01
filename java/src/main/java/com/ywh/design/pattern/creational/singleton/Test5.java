package com.ywh.design.pattern.creational.singleton;

/**
 * 懒汉模式（双重同步锁）
 */
public class Test5 {

    // 私有构造函数
    private Test5() {
    }

    // 创建单例的过程：
    // memory = allocate() 分配对象的内存空间
    // ctorInstance() 初始化对象
    // instance = memory 设置instance指向刚分配的内存

    // 1. 单例对象 volatile + 双重检测机制 -> 禁止指令重排
    private volatile static Test5 instance = null;

    /**
     * 静态的工厂方法
     *
     * @return 获取单例对象
     */
    public static Test5 getInstance() {

        // 2. 双重检测机制之一：判断单例是否已被初始化（由于不存在指令重排，执行判断时若 instance 不为空则必然已经被初始化）
        if (instance == null) {

            // 3. 双重检测机制之二：执行初始化时加上同步锁
            synchronized (Test5.class) {
                if (instance == null) {
                    instance = new Test5();
                }
            }
        }
        return instance;
    }
}
