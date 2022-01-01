package com.ywh.design.pattern.behavioral.command;

/**
 * 课程视频类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println(this.name + "课程视频开放");
    }

    public void close() {
        System.out.println(this.name + "课程视频关闭");
    }

}
