package com.ywh.design.pattern.structural.proxy;

import com.ywh.design.pattern.structural.proxy.order.IOrderService;
import com.ywh.design.pattern.structural.proxy.order.Order;
import com.ywh.design.pattern.structural.proxy.order.OrderServiceImpl;
import com.ywh.design.pattern.structural.proxy.db.DataSourceContextHolder;
import com.ywh.design.pattern.structural.proxy.db.DataSourceContextHolder;

/**
 * 订单静态代理类
 */
public class OrderServiceStaticProxy {

    private IOrderService iOrderService;

    /**
     * 代理了 saveOrder 方法，并通过添加 beforeMethod 和 afterMethod 逻辑增强功能
     *
     * @param order
     * @return
     */
    public int saveOrder(Order order) {
        beforeMethod(order);
        iOrderService = new OrderServiceImpl();
        int result = iOrderService.saveOrder(order);
        afterMethod();
        return result;
    }

    /**
     * 前置操作：用户请求后根据 id 选择分库连接
     *
     * @param order
     */
    private void beforeMethod(Order order) {
        int userId = order.getUserId();

        // 根据用户 id 分库
        int dbRouter = userId % 2;
        System.out.println("静态代理分配到【db" + dbRouter + "】处理数据");

        // 加载数据源（需要需要设置 dataSource）
        DataSourceContextHolder.setDBType("db" + String.valueOf(dbRouter));
        System.out.println("静态代理 before code");
    }

    /**
     * 后置操作
     */
    private void afterMethod() {
        System.out.println("静态代理 after code");
    }
}
