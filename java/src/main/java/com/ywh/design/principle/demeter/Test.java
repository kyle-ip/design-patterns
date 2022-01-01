package com.ywh.design.principle.demeter;

/**
 * 迪米特（最少知道）原则
 * <p>
 * Created by ywh
 */
public class Test {
    public static void main(String[] args) {

        // Boss 向 TeamLeader 下达指令统计数量，但不应该知道具体有哪些课程
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandCheckNumber(teamLeader);
    }
}
