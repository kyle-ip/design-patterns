package com.ywh.design.principle.singleresponsibility;

/**
 * 课程类，实现两个接口，同时具备课程学习和管理的功能
 *
 * Created by ywh
 */
public class CourseImpl implements ICourseManager,ICourseContent {

    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }

    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }
}
