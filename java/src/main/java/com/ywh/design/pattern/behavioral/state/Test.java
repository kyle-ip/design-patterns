package com.ywh.design.pattern.behavioral.state;

/**
 * 状态模式（重点）：允许一个对象在其内部状态时，改变它的行为；
 * 一个对象存在多个状态（不同状态下行为不同），且状态可以相互转换；
 * 将不同的状态隔离，把状态转换逻辑分布到 State 的子类中，减少相互依赖；
 * 增加新的状态非常简单，但状态多的业务场景导致类数目增加，系统变复杂；
 * 组合：状态模式和享元模式。
 * @since 2019/1/12
 */
public class Test {

    public static void main(String[] args) {
        CourseVideoContext courseVideoContext = new CourseVideoContext();

        courseVideoContext.setCourseVideoState(new PlayState());
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.pause();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.stop();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        courseVideoContext.speed();
        System.out.println("当前状态：" + courseVideoContext.getCourseVideoState().getClass().getSimpleName());

        // JSF 源码中的应用：LifeCycle

    }

}
