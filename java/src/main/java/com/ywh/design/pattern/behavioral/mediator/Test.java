package com.ywh.design.pattern.behavioral.mediator;

/**
 * 中介者模式：定义一个封装一组对象如何交互的对象；
 * 通过使对象明确地相互引用促进松散耦合，并允许独立地改变它们的交互；
 * 当系统中对象之间存在复杂的引用关系，产生的相互依赖关系结构混乱难以理解适用；
 * 对于交互的公共行为，如果需要改变行为则可以增加新的中介者类；
 * 可以将一对多转化成一对一的关系，降低程序复杂度，同时实现类之间的解耦；
 * 当中介者过多，可能导致系统复杂；
 * 组合：中介者模式和观察者模式。
 */
public class Test {

    public static void main(String[] args) {
        User ywh = new User("ywh");
        User tom = new User("tom");

        ywh.sendMessage("Hey! Tom!");
        tom.sendMessage("Hey! Ywh!");

        // JDK 源码中的应用：Timer
    }

}
