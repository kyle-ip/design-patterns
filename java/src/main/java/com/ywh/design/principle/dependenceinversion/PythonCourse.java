package com.ywh.design.principle.dependenceinversion;

/**
 * Python 课程学习类
 * <p>
 * Created by ywh
 */
public class PythonCourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("ywh 在学习Python课程");
    }
}
