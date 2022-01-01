package com.ywh.design.pattern.behavioral.strategy;

/**
 * 促销活动类
 */
public class PromotionActivity {
    private PromotionStrategy promotionStrategy;

    public PromotionActivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void executePromotionStrategy() {
        promotionStrategy.doPromotion();
    }

    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }
}
