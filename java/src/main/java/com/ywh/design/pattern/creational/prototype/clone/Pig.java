package com.ywh.design.pattern.creational.prototype.clone;

import java.util.Date;

/**
 * 猪类
 */
public class Pig implements Cloneable {

    private String name;

    private Date birthday;

    public Pig(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 浅克隆：只调用父类的 clone 方法，如果修改 pig1 的属性值， pig2 也会受到影响
        Pig pig = (Pig) super.clone();

        // 深克隆：对于对象的属性也调用依次 clone 方法，表示除了对象以外，其属性也要克隆
        pig.birthday = (Date) pig.birthday.clone();
        return pig;
    }

    @Override
    public String toString() {
        return "Pig{" +
            "name='" + name + '\'' +
            ", birthday=" + birthday +
            '}' + super.toString();
    }
}
