package com.ywh.design.pattern.behavioral.strategy;

/**
 * @author ywh
 * @since 2018/12/27
 */
public class EmptyPromotionStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("无促销活动。");
    }
}
