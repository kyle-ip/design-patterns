package com.ywh.design.pattern.structural.flyweight;

/**
 * 享元模式（重点）：提供了减少对象数量从而改善应用所需的对象结构的方式，运用共享技术有效支持大量细粒度的对象；
 * 常用于系统底层开发，解决系统性能问题（如 Java String 缓存池、数据库连接池），也适用于系统中有大量相似对象，需要缓冲池的场景；
 * 减少对象的创建，降低内存中对象的数量，降低内存和其他资源占用（new 创建对象的次数、文件句柄）、提高效率；
 * 需要关注内部和外部状态、关注线程安全问题，而且系统程序的逻辑更复杂；
 * 内部状态：不受外部环境影响而改变的部分（对象属性）；
 * 外部状态：记录在享元对象外部，不可共享（外部传入的参数）；
 * 对比：享元模式和代理模式；
 * 组合：享元模式和单例模式（容器单例，复用对象的思想）、享元模式和工厂模式。
 */
public class Test {
    private static final String departments[] = {"RD", "QA", "PM", "BD"};

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 随机抽取部门，让经理做报告（被抽出的经理缓存在 EmployeeFactory 中，下次不需要 new 创建）
            String department = departments[(int) (Math.random() * departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }

        // common.pool 源码中的应用：GenericObjectPool，GenericKeyedObjectPool
    }

    public static void test() {
        // JDK 源码中的应用：
        // Integer 的 valueOf 方法，数值在范围内（最小值 -128，最大值于 JVM 参数设定）则直接从缓存池中获取返回，否则创建新的对象

        // true，直接从缓存获取
        Integer a = Integer.valueOf(100);
        Integer b = 100;

        // false，缓存范围外， new 创建
        Integer c = Integer.valueOf(1000);
        Integer d = 1000;

        System.out.println("a == b: " + (a == b));

        System.out.println("c == d: " + (c == d));
    }
}
