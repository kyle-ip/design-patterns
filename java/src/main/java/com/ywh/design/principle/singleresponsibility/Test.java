package com.ywh.design.principle.singleresponsibility;

/**
 * 单一职责原则
 *
 * Created by ywh
 */
public class Test {
    public static void main(String[] args) {

        // 鸟类承担判断并执行“用脚走”、“用翅膀飞”的功能，不满足单一职责原则，修改风险大
//        Bird bird = new Bird();
//        bird.mainMoveMode("大雁");
//        bird.mainMoveMode("鸵鸟");

        // 把鸟类拆分成飞鸟和步行鸟，分别承担两种功能，可避免由于修改引起其他问题
        FlyBird flyBird = new FlyBird();
        flyBird.mainMoveMode("大雁");

        WalkBird walkBird = new WalkBird();
        walkBird.mainMoveMode("鸵鸟");

    }
}
