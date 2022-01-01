package com.ywh.design.pattern.behavioral.command;

/**
 * 关闭课程命令类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class CloseCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}
