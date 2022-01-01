package com.ywh.design.pattern.behavioral.state;

import com.ywh.design.pattern.behavioral.command.CourseVideo;

/**
 * @author ywh
 * @since 2019/1/12
 */
public class PlayState extends CourseVideoState {

    @Override
    public void play() {
        System.out.println("播放状态");
    }

    @Override
    public void speed() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.SPEED_STATE);
    }

    @Override
    public void pause() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PAUSE_STATE);
    }

    @Override
    public void stop() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.STOP_STATE);
    }
}
