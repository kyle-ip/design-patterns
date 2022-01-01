package com.ywh.design.pattern.behavioral.strategy;

/**
 * 策略模式（重点）：定义了算法家族，分别封装起来，使之可以互相替换，让算法的变化不会影响到使用算法的用户；
 * 算法替换方便，代替了大量的 if...else... 结构；
 * 当系统有很多类且区别仅在于行为不同，或系统需要动态地从几种算法中选择时适用；
 * 不需要修改系统即可扩展行为，也避免适用多重条件转移语句，满足开闭原则；
 * 可提高算法保密性和安全性（对客户端透明）；
 * 可能产生大量策列类，客户端必须知道所有策略类，自行决定使用哪个；
 * 对比：策略模式和工厂模式，策略模式和状态模式。
 */
public class Test {
    public static void main(String[] args) {

        // 促销活动类是客户端入口，传入指定的策略后可以统一的接口 executePromotionStrategy 调用策略方法，也可以动态替换策略对象
//        PromotionActivity promotionActivity = new PromotionActivity(new LiJianPromotionStrategy());
//        promotionActivity.executePromotionStrategy();
//        promotionActivity.setPromotionStrategy(new FanXianPromotionStrategy());
//        promotionActivity.executePromotionStrategy();

        // 策略模式结合简单工厂模式使用
        String promotionKey = "LIJIAN";
        PromotionActivity promotionActivity = new PromotionActivity(
            PromotionStrategyFactory.getPromotionStrategy(promotionKey)
        );
        promotionActivity.executePromotionStrategy();

        // JDK 源码中的应用：Comparator（比如排序可以传入自己定义的比较器，即策略）
        // Spring 源码中的应用：ClassPathResource
    }
}
