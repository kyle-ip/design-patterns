package com.ywh.design.pattern.behavioral.observer;

import com.google.common.eventbus.EventBus;

/**
 * 观察者模式：定义了对象之间一对多的依赖，让多个观察者对象同时监听某个主题对象，当对象发生变化时，所有观察者都会收到通知；
 * 关联行为场景，建立一套触发机制；
 * 观察者和被观察者之间建立一个抽象的耦合，支持广播通信；
 * 观察者之间有过多的细节依赖、提高了时间消耗和程序复杂度；
 * 要避免循环调用，因此要使用得当。
 */
public class Test {

    public static void main(String[] args) {

        // 定义被观察对象、观察者
        Course course = new Course("《Java 设计模式》");
        Teacher teacher1 = new Teacher("A");
        Teacher teacher2 = new Teacher("B");

        course.addObserver(teacher1);
        course.addObserver(teacher2);

        // 发送通知
        Question question = new Question();
        question.setUserName("ywh");
        question.setQuestionContent("psvm 是什么快捷键？");
        course.produceQuestion(course, question);

        EventBus eventBus = new EventBus();
        GuavaEvent guavaEvent = new GuavaEvent();
        eventBus.register(guavaEvent);
        eventBus.post("测试发送通知");


        // JDK 源码中的应用：awt.Event

        // Spring 源码中的应用：RequestContextListener
    }


}
