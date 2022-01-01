package com.ywh.design.principle.interfacesegregation;

/**
 * 动物行为接口，缺点在于不是所有动物都具备接口中的所有行为，但实现接口又必须实现其所有方法
 *
 * Created by ywh
 */
public interface IAnimalAction {

    void eat();

    void fly();

    void swim();

}
