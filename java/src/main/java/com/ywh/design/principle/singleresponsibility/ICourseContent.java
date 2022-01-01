package com.ywh.design.principle.singleresponsibility;

/**
 * 课程内容接口，获取名称、视频
 * <p>
 * Created by ywh
 */
public interface ICourseContent {
    String getCourseName();

    byte[] getCourseVideo();
}
