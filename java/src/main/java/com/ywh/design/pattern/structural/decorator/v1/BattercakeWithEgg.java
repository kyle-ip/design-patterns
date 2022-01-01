package com.ywh.design.pattern.structural.decorator.v1;

/**
 * 煎饼加鸡蛋类
 */
public class BattercakeWithEgg extends Battercake {
    @Override
    public String getDesc() {
        return super.getDesc() + " 加一个鸡蛋";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
