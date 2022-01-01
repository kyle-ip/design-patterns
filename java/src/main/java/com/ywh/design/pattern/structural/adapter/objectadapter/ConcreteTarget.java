package com.ywh.design.pattern.structural.adapter.objectadapter;

/**
 * 目标类
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }

}
