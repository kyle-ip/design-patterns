package com.ywh.design.pattern.behavioral.observer;

import com.google.common.eventbus.Subscribe;

/**
 * @author ywh
 * @since 2019/1/12
 */
public class GuavaEvent {

    @Subscribe
    public void subscribe(String str) {
        // 业务逻辑
        System.out.println("执行 Subscribe 方法，传入的参数是：" + str);

    }

}
