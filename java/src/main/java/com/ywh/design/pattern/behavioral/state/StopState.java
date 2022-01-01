package com.ywh.design.pattern.behavioral.state;

/**
 * @author ywh
 * @since 2019/1/12
 */
public class StopState extends CourseVideoState {
    @Override
    public void play() {
        super.courseVideoContext.setCourseVideoState(CourseVideoContext.PLAY_STATE);
    }

    @Override
    public void speed() {
        System.out.println("停止状态禁止快进");
    }

    @Override
    public void pause() {
        System.out.println("停止状态禁止暂停");
    }

    @Override
    public void stop() {
        System.out.println("停止状态");
    }
}
