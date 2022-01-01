package com.ywh.design.pattern.behavioral.state;

/**
 * @author ywh
 * @since 2019/1/12
 */
public abstract class CourseVideoState {

    protected CourseVideoContext courseVideoContext;

    public CourseVideoContext getCourseVideoContext() {
        return courseVideoContext;
    }

    public void setCourseVideoContext(CourseVideoContext courseVideoContext) {
        this.courseVideoContext = courseVideoContext;
    }

    public abstract void play();

    public abstract void speed();

    public abstract void pause();

    public abstract void stop();

}
