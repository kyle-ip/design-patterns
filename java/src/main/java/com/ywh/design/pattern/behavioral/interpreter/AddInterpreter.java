package com.ywh.design.pattern.behavioral.interpreter;

/**
 * @author ywh
 * @since 2018/12/28
 */
public class AddInterpreter implements Interpreter {

    private Interpreter firstExpression, secondExpression;

    @Override
    public int interpret() {
        return 1;
    }

}
