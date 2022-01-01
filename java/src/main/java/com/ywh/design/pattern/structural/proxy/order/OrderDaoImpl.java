package com.ywh.design.pattern.structural.proxy.order;

/**
 * 订单数据访问类
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao 层添加 Order 成功");
        return 1;
    }
}
