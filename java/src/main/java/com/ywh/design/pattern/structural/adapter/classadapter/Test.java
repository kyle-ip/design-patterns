package com.ywh.design.pattern.structural.adapter.classadapter;

/**
 * 类适配器，通过继承实现
 * 被适配者 + 适配器 -> 目标，要求适配器类继承被适配者类，并实现目标接口
 * 则目标方法：
 *      适配前 adapteeRequest
 *      适配后 request
 */
public class Test {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
