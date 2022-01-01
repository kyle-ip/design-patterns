package com.ywh.design.pattern.structural.bridge;

/**
 * 中国银行类
 */
public class ABCBank extends Bank {
    public ABCBank(Account account) {
        super(account);
    }

    @Override
    public Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }
}
