package com.ywh.design.pattern.structural.bridge;

/**
 * 桥接模式（重点）：将抽象部分和具体实现部分分离，使各自可以独立地变化，通过组合的方式（委托行为方法）建立两个类的联系；
 * 抽象与具体实现之间需要增加更多灵活性，或一个类存在多个独立变化的维度且维度都需要独立扩展时适用；
 * 不希望使用继承的原因是多层继承会导致系统类的个数剧增；
 * 分离抽象部分及其具体实现部分，提高了系统的可扩展性，符合开闭原则和合成复用原则；
 * 增加了系统的理解和设计难度，而且需要正确地识别系统中两个独立变化的维度；
 *
 * 对比：桥接模式和组合模式、桥接模式和适配器模式。
 */
public class Test {
    public static void main(String[] args) {

        // 账号有活期和定期两种，银行有工商银行和农业银行两种，两两产生有四种组合
        // Bank 的 openAccount 委托给 Account 的 openAccount 方法（重要），表示调用银行的开户方法是调用其注入账户的开户方法

        // 创建工商银行的定期账号
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

        // 创建工商银行的活期账号
        Bank icbcBank2 = new ICBCBank(new SavingAccount());
        Account icbcAccount2 = icbcBank2.openAccount();
        icbcAccount2.showAccountType();

        // 创建农业银行的活期账号
        Bank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();

        // JDBC 源码中的应用：java.sql.Driver、DriverManager（DriverInfo、getConnection）
    }
}
