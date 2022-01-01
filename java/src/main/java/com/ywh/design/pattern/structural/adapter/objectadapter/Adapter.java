package com.ywh.design.pattern.structural.adapter.objectadapter;

/**
 * 适配器类
 */
public class Adapter implements Target {

    // 指定被适配者对象
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //...
        adaptee.adapteeRequest();
        //...
    }
}
