package com.ywh.design.pattern.behavioral.command;

/**
 * 开启课程命令类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class OpenCourseVideoCommand implements  Command {

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.open();
    }
}
