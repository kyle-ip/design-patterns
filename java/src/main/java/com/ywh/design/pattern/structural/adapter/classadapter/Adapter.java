package com.ywh.design.pattern.structural.adapter.classadapter;

/**
 * 适配器类
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        //...
        super.adapteeRequest();
        //...
    }
}
