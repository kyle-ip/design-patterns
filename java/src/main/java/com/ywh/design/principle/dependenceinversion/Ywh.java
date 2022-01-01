package com.ywh.design.principle.dependenceinversion;

/**
 * 人物类，稳定而不依赖于任何课程，可以随意学习扩展的课程
 * <p>
 * Created by ywh
 */
public class Ywh {

    // v1 缺点：面向实现编程，功能直接添加到实现类，高层模块依赖底层模块，扩展性差
    public void studyJavaCourse() {
        System.out.println("学习 Java 课程");
    }

    public void studyPythonCourse() {
        System.out.println("学习 Python 课程");
    }

    // v2、v3 缺点：构造器注入，由于 iCourse 域不能修改，选择不同课程时还需要创建新的实例，适用场景少
    public Ywh(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public Ywh() {
    }

    /**
     * v4 Setter 方法注入，不依赖于构造器，随时可以设置学习的课程
     *
     * @param iCourse
     */
    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }


    private ICourse iCourse;


    public void studyImoocCourse() {
        iCourse.studyCourse();
    }

    public void studyImoocCourse(ICourse iCourse) {
        iCourse.studyCourse();
    }


}
