package com.ywh.design.pattern.behavioral.strategy;

/**
 * 返现策略类
 */
public class FanXianPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("返现促销，返回的金额存放到慕课网用户的余额中。");
    }
}
