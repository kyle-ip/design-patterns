package com.ywh.design.pattern.creational.singleton.bak;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式（重点）：保证一个类仅有一个实例，并提供一个全局访问点（确保任何情况下都只有一个实例）；
 * 在内存仲只有一个实例，减少内存开销；
 * 可以避免对资源的多重占用；
 * 设置全局访问点，严格控制访问；
 * 没有接口，扩展困难；
 *
 * 重点：私有构造器，线程安全，延迟加载，序列化与反序列化安全，反射
 * 组合：单例模式 + 工厂模式，单例模式 + 享元模式
 */
public class Test {
    public static void main(String[] args) throws
        IOException,
        ClassNotFoundException,
        NoSuchMethodException,
        IllegalAccessException,
        InvocationTargetException,
        InstantiationException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();

//        System.out.println("main thread" + ThreadLocalInstance.getInstance());

        Thread t1 = new Thread(new T());
        Thread t2 = new Thread(new T());
        t1.start();
        t2.start();
        System.out.println("program end");



//        HungrySingleton instance = HungrySingleton.getInstance();
//        EnumInstance instance = EnumInstance.getInstance();
//        instance.setData(new Object());
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(instance);
//
//        File file = new File("singleton_file");
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//
////        HungrySingleton newInstance = (HungrySingleton) ois.readObject();
//        EnumInstance newInstance = (EnumInstance) ois.readObject();
//
//        System.out.println(instance.getData());
//        System.out.println(newInstance.getData());
//        System.out.println(instance.getData() == newInstance.getData());

//        Class objectClass = HungrySingleton.class;
//        Class objectClass = StaticInnerClassSingleton.class;

//        Class objectClass = LazySingleton.class;
//        Class objectClass = EnumInstance.class;
////
//        Constructor constructor = objectClass.getDeclaredConstructor(String.class,int.class);
//
//        constructor.setAccessible(true);
//        EnumInstance instance = (EnumInstance) constructor.newInstance("ywh",666);


//
//        LazySingleton newInstance = (LazySingleton) constructor.newInstance();
//        LazySingleton instance = LazySingleton.getInstance();


//        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
//        StaticInnerClassSingleton newInstance = (StaticInnerClassSingleton) constructor.newInstance();

//        HungrySingleton newInstance = (HungrySingleton) constructor.newInstance();
//        HungrySingleton instance = HungrySingleton.getInstance();


//        System.out.println(instance);
//        System.out.println(newInstance);
//        System.out.println(instance == newInstance);

        EnumInstance instance = EnumInstance.getInstance();
        instance.printTest();


    }
}
