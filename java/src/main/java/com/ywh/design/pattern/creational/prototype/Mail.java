package com.ywh.design.pattern.creational.prototype;

import lombok.Data;

/**
 * 电子邮件类
 */
@Data
public class Mail implements Cloneable {

    private String name;

    private String emailAddress;

    private String content;

    public Mail() {
        System.out.println("Mail Class Constructor");
    }

    @Override
    public String toString() {
        return "Mail{" +
            "name='" + name + '\'' +
            ", emailAddress='" + emailAddress + '\'' +
            ", content='" + content + '\'' +
            '}' + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("clone mail object");
        return super.clone();
    }
}
