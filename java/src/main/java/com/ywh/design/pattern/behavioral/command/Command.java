package com.ywh.design.pattern.behavioral.command;

/**
 * 命令接口
 */
public interface Command {

    /**
     * 命令类统一对外暴露 execute 接口，统一执行方式
     */
    void execute();
}
