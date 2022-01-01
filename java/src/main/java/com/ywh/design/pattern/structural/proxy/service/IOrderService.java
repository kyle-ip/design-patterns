package com.ywh.design.pattern.structural.proxy.service;

import com.ywh.design.pattern.structural.proxy.entity.Order;

/**
 * Created by ywh
 */
public interface IOrderService {
    int saveOrder(Order order);
}
