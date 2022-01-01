package com.ywh.design.pattern.behavioral.mediator;

import java.util.Date;

/**
 * 学习小组类（中介者）
 *
 * @author ywh
 * @since 2019/1/12
 */
public class StudyGroup {

    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString() + " [" + user.getName() + "]: " + message);
    }

}
