package com.ywh.design.pattern.structural.facade;

/**
 * 外观模式（重点）：提供一个统一的高层接口，用来访问子系统中的一群接口（让子系统更容易使用）；
 * 当子系统越来越复杂可使用外观模式增加简单调用接口，或需要构建多层系统结构时使用外观对象作每层入口简化层间调用；
 * 简化调用过程，无需深入了解子系统，防止带来风险（符合迪米特法则，即最少知道原则）；
 * 减少系统依赖，松散耦合；
 * 更好地划分访问层次；
 * 增加、扩展子系统时容易引入风险，而且不符合开闭原则（变更频繁时可使用抽象外观类）；
 *
 * 对比：外观模式和中介者模式；
 * 组合：外观模式 + 单例模式，外观模式 + 抽象工厂模式。
 */
public class Test {
    public static void main(String[] args) {
        PointsGift pointsGift = new PointsGift("T恤");

        // 礼物兑换服务封装了积分校验、积分兑换、物流系统服务，调用方不需要知道礼物兑换的中间细节
        GiftExchangeService giftExchangeService = new GiftExchangeService();
        giftExchangeService.giftExchange(pointsGift);

        // Spring JDBC 源码中的应用：org.springframework.jdbc.support.JdbcUtils
        //      closeConnection、closeStatement...
        // Mybatis 源码中的应用：org.apache.ibatis.session.Configuration
        //      newMetaObject
        // Tomcat 源码中的应用：RequestFacade，Request，RequestFacade
    }
}
