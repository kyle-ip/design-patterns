package com.ywh.design.pattern.structural.decorator.v2;

/**
 * 煎饼类
 */
public class Battercake extends ABattercake {
    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
