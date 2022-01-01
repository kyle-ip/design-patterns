package com.ywh.design.pattern.creational.singleton.bak;

/**
 * 懒汉型单例模式：延迟加载（用时实例化） + 私有构造方法
 * 线程不安全：两个线程可能同时进入“实例是否为空”的判断，并各自实例化返回对象
 * 需要加上 synchronized 加锁确保线程安全
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {
        if (lazySingleton != null) {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    /**
     * 获取实例
     *
     * @return
     */
    public synchronized static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        Class objectClass = LazySingleton.class;
//        Constructor c = objectClass.getDeclaredConstructor();
//        c.setAccessible(true);
//
//        LazySingleton o1 = LazySingleton.getInstance();
//
//        Field flag = o1.getClass().getDeclaredField("flag");
//        flag.setAccessible(true);
//        flag.set(o1,true);
//
//
//        LazySingleton o2 = (LazySingleton) c.newInstance();
//
//        System.out.println(o1);
//        System.out.println(o2);
//        System.out.println(o1==o2);
//    }

}
