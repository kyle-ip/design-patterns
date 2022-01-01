package com.ywh.design.pattern.structural.proxy.order;

/**
 * 订单服务类
 */
public class OrderServiceImpl implements IOrderService {

    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service 层调用 Dao 层添加 Order ");
        return iOrderDao.insert(order);
    }

}