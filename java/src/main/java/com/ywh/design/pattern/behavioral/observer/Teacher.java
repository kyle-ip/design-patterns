package com.ywh.design.pattern.behavioral.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 讲师类：观察者
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Teacher implements Observer {

    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 观察者接收通知
     * @param o     被观察对象
     * @param arg   通知参数
     */
    @Override
    public void update(Observable o, Object arg) {
        Course course = (Course) o;
        Question question = (Question) arg;
        System.out.println(teacherName + " 老师的" + course.getCourseName() + "课程接收到一个 " + question.getUserName() + " 提交的问题：" + question.getQuestionContent());
    }
}
