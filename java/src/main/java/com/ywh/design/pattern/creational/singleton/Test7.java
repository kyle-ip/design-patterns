package com.ywh.design.pattern.creational.singleton;

/**
 * 枚举模式：最安全
 */
public class Test7 {

    // 私有构造函数
    private Test7() {}

    public static Test7 getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

    private enum SingletonEnum {

        /**
         * 单例对象
         */
        INSTANCE;

        private Test7 singleton;

        // JVM 保证这个方法只调用一次
        SingletonEnum() {
            singleton = new Test7();
        }

        public Test7 getInstance() {
            return singleton;
        }
    }
}
