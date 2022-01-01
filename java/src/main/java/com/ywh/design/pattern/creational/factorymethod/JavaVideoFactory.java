package com.ywh.design.pattern.creational.factorymethod;

/**
 * Java 视频工厂类
 */
public class JavaVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}
