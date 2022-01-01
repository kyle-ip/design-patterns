package com.ywh.design.pattern.creational.simplefactory;

/**
 * Python 视频类
 */
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制Python课程视频");
    }
}
