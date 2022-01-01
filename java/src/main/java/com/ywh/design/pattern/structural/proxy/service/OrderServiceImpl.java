package com.ywh.design.pattern.structural.proxy.service;

import com.ywh.design.pattern.structural.proxy.entity.Order;
import com.ywh.design.pattern.structural.proxy.dao.IOrderDao;
import com.ywh.design.pattern.structural.proxy.dao.OrderDaoImpl;

/**
 * Created by ywh
 */
public class OrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao;


    @Override
    public int saveOrder(Order order) {
        //Spring会自己注入，我们课程中就直接new了
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }

}
