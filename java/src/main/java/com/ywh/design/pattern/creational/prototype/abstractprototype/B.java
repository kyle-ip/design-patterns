package com.ywh.design.pattern.creational.prototype.abstractprototype;

/**
 * B 继承自 A，因此 B 也可被克隆
 */
public class B extends A {
    public static void main(String[] args) throws CloneNotSupportedException {
        B b = new B();
        b.clone();
    }
}
