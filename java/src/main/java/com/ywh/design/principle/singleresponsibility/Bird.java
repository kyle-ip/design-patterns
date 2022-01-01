package com.ywh.design.principle.singleresponsibility;

/**
 * 鸟类
 * <p>
 * Created by ywh
 */
public class Bird {

    public void mainMoveMode(String birdName) {

        if ("鸵鸟".equals(birdName)) {
            System.out.println(birdName + "用脚走");
        } else {
            System.out.println(birdName + "用翅膀飞");
        }
    }
}
