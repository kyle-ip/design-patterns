package com.ywh.design.principle.openclose;

/**
 * 优惠 Java 课程类
 * 需求是在原课程价格的基础上添加折扣价；
 * 避免直接修改接口和实现类（稳定），添加一个继承的实现类，在子类上扩展功能。
 *
 * Created by ywh
 */
public class JavaDiscountCourse extends JavaCourse {

    /**
     * 默认构造器：调用父类构造器
     *
     * @param id    课程 id
     * @param name  课程名称
     * @param price 价格
     */
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    /**
     * 折扣价，调用父类价格的基础上加上折扣
     *
     * @return 折扣价
     */
    public Double getDiscountPrice() {
        return super.getPrice() * 0.8;
    }

}
