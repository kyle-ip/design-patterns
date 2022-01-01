package com.ywh.design.pattern.structural.proxy;

import com.ywh.design.pattern.structural.proxy.order.IOrderService;
import com.ywh.design.pattern.structural.proxy.order.Order;
import com.ywh.design.pattern.structural.proxy.order.OrderServiceImpl;

/**
 * 代理模式（重点）：为其他对象提供一种代理以控制对这个对象的访问，代理对象在客户端和目标对象之间起中介作用；
 * 目标是保护目标对象（不被客户端直接操作）/增强目标对象（添加前置、后置操作）；
 * 能将代理对象与真实被调用目标对象分离，一定程度上减低系统耦合度，扩展性好；
 * 可能造成系统设计中类的数目增加、增加系统复杂度，同时使请求速度变慢；
 * 分为静态代理、动态代理（无法代理类，只能代理接口）、CGLib 代理；
 * 对比：代理模式和装饰者模式，代理模式和适配器模式。
 *
 * 静态代理：在代码中显式指定代理；
 * 动态代理：对接口生成代理（不能针对具体的类）；
 * CGLib 代理：
 *
 * Spring 代理选择：
 * Bean 有实现接口时，Spring 就会用 JDK 的动态代理，否则使用 CGLib
 * 也可以强制使用 CGlib：<aop:aspectj-autoproxy proxy-target-class="true">
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);

        // 动态代理
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(order);


        // 静态代理
        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);

    }
}
