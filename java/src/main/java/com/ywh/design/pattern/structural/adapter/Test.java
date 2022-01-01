package com.ywh.design.pattern.structural.adapter;

/**
 * 适配器模式（重点）：将一个类的接口转换成客户端期望的另一种接口，使原本接口不兼容的类可以一起工作；
 * 对于已存在的类，其方法和需求不匹配（方法结果相似）时可以考虑使用；
 * 适配器模式不是软件设计阶段考虑的，而是随着软件维护阶段出现接口不匹配的情况下做出的解决方案；
 * 能提高类的透明性和复用，现有的类复用但不需要改变；
 * 目标类和适配器类解耦，提高程序扩展性，符合开闭原则；
 * 适配器编写过程需要全面考虑，可能会增加系统复杂性，且降低系统代码可读性；
 * 适配器分为类适配器和对象适配器（被适配者类 Adaptee 与目标接口 Target 相同、客户端调用方式相同），优先选择组合方式；
 * 对比：适配器模式和外观模式。
 */
public class Test {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter();

        // 隐藏 220V 交流电转化为 5V 直流电的细节
        dc5.outputDC5V();

        // JAXB 源码中的应用：XmlAdapter
        // Spring AOP 源码中的应用：AdvisorAdapter
        // Spring MVC 源码中的应用：HandlerAdapter（适配其中的 Controller，即被适配者），DispatcherServlet（可理解为适配器中的客户端，doDispatcher）
    }
}
