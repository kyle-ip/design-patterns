package com.ywh.design.pattern.creational.simplefactory;

import com.mysql.jdbc.Driver;
import org.slf4j.LoggerFactory;

import java.sql.DriverManager;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 简单工厂模式：由一个工厂对象决定创建出哪一种产品类的实例（不属于 GOF 23种设计模式）；
 * 当工厂类负责创建的对象比较少、客户端只知道传入工厂类的参数（就可以获取需要的对象），对于如何创建对象不关心时适用；
 * 工厂类的职责过重，增加新产品需要修改工厂类判断逻辑，违背开放封闭原则，而且也无法形成基于继承的等级结构。
 *
 * Created by ywh
 */
public class Test {
    public static void main(String[] args) {

        // v1：客户端直接使用产品类创建对象，扩展需要修改客户端，不满足开放封闭原则
//        Video video = new PythonVideo();
//        video.produce();

        // v2：客户端向工厂指定产品类型名称，由工厂创建产品对象并返回，但由于扩展时需要修改工厂类判断逻辑，仍不满足开放封闭原则
//        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
//        if(video == null){
//            return;
//        }
//        video.produce();

        // v3：利用反射，客户端需要生产的产品类型并向工厂传递，由工厂根据指定类型创建对象并返回（而不需要在工厂类进行判断了）
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if (video == null) {
            return;
        }
        video.produce();

        // JDK 源码中的应用：Calendar.getInstance（if...else...）、com.mysql.jdbc.Driver（Class.forName）、LoggerFactory.getLogger（clazz.getName）
    }

}
