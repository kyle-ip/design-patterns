package com.ywh.design.pattern.behavioral.chainofresponsibility;

/**
 * 审批者类
 *
 * @author ywh
 * @since 2019/1/12
 */
public abstract class Approver {

    protected Approver approver;

    public void setNextApprover(Approver approver) {
        this.approver = approver;
    }

    public abstract void deploy(Course course);
}
