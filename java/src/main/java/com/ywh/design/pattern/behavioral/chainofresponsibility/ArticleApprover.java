package com.ywh.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * 手记审批者类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class ArticleApprover extends Approver {

    @Override
    public void deploy(Course course) {

        if (StringUtils.isNotEmpty(course.getArticle())) {
            System.out.println(course.getArticle() + "包含手记，批准");
            if (approver != null) {
                approver.deploy(course);
            }
        } else {
            System.out.println(course.getName() + "不包含手记，不批准，流程结束");
        }

    }

}
