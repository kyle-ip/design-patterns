package com.ywh.design.pattern.behavioral.chainofresponsibility;

import org.apache.commons.lang3.StringUtils;

/**
 * 视频审批者类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class VideoApprover extends Approver {

    @Override
    public void deploy(Course course) {
        if (StringUtils.isNotEmpty(course.getVideo())) {
            System.out.println(course.getVideo() + "包含视频，批准");
            if (approver != null) {
                approver.deploy(course);
            } else {
                System.out.println("流程结束");
            }
        } else {
            System.out.println(course.getName() + "不包含视频，不批准，流程结束");
        }

    }
}
