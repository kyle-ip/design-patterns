package com.ywh.design.pattern.behavioral.mediator;

/**
 * 用户类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class User {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 交由中介者发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        StudyGroup.showMessage(this, message);
    }

}
