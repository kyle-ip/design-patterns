package com.ywh.design.pattern.creational.prototype;

/**
 * 原型模式：原型实例指定创建对象的种类，并且通过克隆这些原型创建新的对象；
 * 不需要知道任何创建的细节，不调用构造函数；
 * 当类初始化消耗较多资源/ 构造函数太复杂/ 循环体中产生大量对象/ new 创建一个对象需要繁琐的过程时适用；
 * 性能比直接 new 创建对象高，而且对象创建过程被简化；
 * 要求类必须实现 clone 方法、实现 Cloneable 接口；
 * 对克隆复杂对象或对克隆出的对象进行复杂改造时容易引入风险；
 * 深克隆、浅克隆要使用得当（需要检查对象是否一致）。
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Mail mail = new Mail();
        mail.setContent("初始化模板");
        System.out.println("初始化mail:" + mail);

        // 假设需要给10位用户发送邮件，使用原型模式不需要 new 创建10个邮件对象，只需要初始化创建一个模板，其他对象都通过 clone 方法复制出来
        for (int i = 0; i < 10; i++) {
            Mail mailTemp = (Mail) mail.clone();
            mailTemp.setName("姓名" + i);
            mailTemp.setEmailAddress("姓名" + i + "@imooc.com");
            mailTemp.setContent("恭喜您，此次慕课网活动中奖了");
            MailUtil.sendMail(mailTemp);
            System.out.println("克隆的mailTemp:" + mailTemp);
        }

        // 存储时则保存初始化模板
        MailUtil.saveOriginMailRecord(mail);

        // JDK 源码中的应用：ArrayList 等实现了 Cloneable 接口的类
    }
}
