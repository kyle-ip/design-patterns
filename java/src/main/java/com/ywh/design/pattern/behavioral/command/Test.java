package com.ywh.design.pattern.behavioral.command;

/**
 * 命令模式：将请求封装成对象以便使用不同的请求；
 * 解决了应用程序中对象的职责以及他们之间的通信方式；
 * 当请求的调用者和请求的接收者需要解耦时，可以使调用者和接收者不直接交互；
 * 可以抽象出等待执行的行为；
 * 容易扩展新命令或一组命令；
 * 命令的无限扩展会增加类的数量，会提供系统复杂度；
 * 组合：命令模式和备忘录模式。
 */
public class Test {

    public static void main(String[] args) {
        CourseVideo courseVideo = new CourseVideo("设计模式");
        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        Staff staff = new Staff();
        staff.addCommand(openCourseVideoCommand);
        staff.addCommand(closeCourseVideoCommand);

        staff.executeCommand();


        // JDK 源码中的应用：Runnable

        // Junit 源码中的应用：Test
    }

}
