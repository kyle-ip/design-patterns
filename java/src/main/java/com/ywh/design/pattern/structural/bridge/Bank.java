package com.ywh.design.pattern.structural.bridge;

import com.ywh.design.pattern.structural.bridge.Account;

/**
 * 抽象银行类
 */
public abstract class Bank {

    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    public abstract Account openAccount();

}
