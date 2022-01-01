package com.ywh.design.principle.dependenceinversion;

/**
 * FE 课程学习类
 * <p>
 * Created by ywh
 */
public class FECourse implements ICourse {

    @Override
    public void studyCourse() {
        System.out.println("ywh 在学习FE课程");
    }

}
