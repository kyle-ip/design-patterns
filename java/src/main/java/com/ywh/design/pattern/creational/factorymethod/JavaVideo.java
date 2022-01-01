package com.ywh.design.pattern.creational.factorymethod;

/**
 * Java 视频类
 */
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Java课程视频");
    }
}
