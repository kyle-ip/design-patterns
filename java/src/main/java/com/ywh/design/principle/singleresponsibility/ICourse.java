package com.ywh.design.principle.singleresponsibility;

/**
 * 课程接口
 * <p>
 * Created by ywh
 */
public interface ICourse {

    String getCourseName();

    byte[] getCourseVideo();

    void studyCourse();

    void refundCourse();

}
