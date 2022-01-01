package com.ywh.design.pattern.creational.prototype.abstractprototype;

public abstract class A implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
