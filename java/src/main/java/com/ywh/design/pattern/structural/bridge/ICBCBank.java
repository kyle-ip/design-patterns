package com.ywh.design.pattern.structural.bridge;

import com.ywh.design.pattern.structural.bridge.Account;
import com.ywh.design.pattern.structural.bridge.Bank;

/**
 * 工商银行类
 */
public class ICBCBank extends Bank {

    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
