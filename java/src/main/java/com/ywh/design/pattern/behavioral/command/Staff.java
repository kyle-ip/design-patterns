package com.ywh.design.pattern.behavioral.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令执行者类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Staff {

    private List<Command> commandList = new ArrayList<Command>();


    public void addCommand(Command command) {
        this.commandList.add(command);
    }

    public void executeCommand() {
        for(Command command: commandList) {
            command.execute();
        }
        commandList.clear();

    }

}
