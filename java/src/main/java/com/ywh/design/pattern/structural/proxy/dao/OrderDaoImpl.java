package com.ywh.design.pattern.structural.proxy.dao;

import com.ywh.design.pattern.structural.proxy.entity.Order;

/**
 * Created by ywh
 */
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
