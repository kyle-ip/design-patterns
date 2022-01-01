package com.ywh.design.pattern.behavioral.observer;

import java.util.Observable;

/**
 * 课程类：被观察对象
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Course extends Observable {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void produceQuestion(Course course, Question question) {
        System.out.println(question.getUserName() + " 在" + course.courseName + "课程提交了一个问题：" + question.getQuestionContent());
        setChanged();
        notifyObservers(question);
    }

}
