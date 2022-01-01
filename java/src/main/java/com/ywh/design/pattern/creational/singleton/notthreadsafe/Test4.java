package com.ywh.design.pattern.creational.singleton.notthreadsafe;

/**
 * （非线程安全）懒汉模式（双重同步锁）
 */
public class Test4 {

    // 私有构造函数
    private Test4() {

    }

    // 创建单例的过程：
    // 1. memory = allocate()   分配对象的内存空间
    // 2. ctorInstance()        初始化对象
    // 3. instance = memory     设置 instance 指向刚分配的内存

    // 但由于 JVM 和 cpu 优化，发生了指令重排，可能修改了创建单例的顺序
    // 1. memory = allocate()   分配对象的内存空间
    // 3. instance = memory     设置 instance 指向刚分配的内存
    // 2. ctorInstance()        初始化对象

    // 单例对象
    private static Test4 instance = null;

    // 静态的工厂方法
    public static Test4 getInstance() {

        // 双重检测机制           // 线程 B 执行判断时，发现已经 instance 已经被线程 A 设值，对象未初始化就直接返回
        if (instance == null) {
            synchronized (Test4.class) {
                // 同步锁
                if (instance == null) {
                                // 假设发生重排，线程 A 执行到第3.步（指向刚分配的内存，但未初始化对象）
                    instance = new Test4();
                }
            }
        }
        return instance;
    }
}
