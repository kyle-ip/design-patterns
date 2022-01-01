package com.ywh.design.pattern.structural.decorator.v1;

/**
 * 煎饼加鸡蛋加香肠类
 */
public class BattercakeWithEggSausage extends BattercakeWithEgg {
    @Override
    public String getDesc() {
        return super.getDesc() + " 加一根香肠";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
