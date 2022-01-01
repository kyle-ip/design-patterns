package com.ywh.design.principle.dependenceinversion;

/**
 * Java 课程学习类
 * <p>
 * Created by ywh
 */
public class JavaCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("ywh 在学习Java课程");
    }
}
