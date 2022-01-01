package com.ywh.design.pattern.behavioral.Memento;

/**
 * 备忘录模式：保存一个对象的某个状态，以便在适当的时候恢复对象（后悔药）；
 * 保存数据相关业务场景，可恢复到之前的场景；
 * 为用户提供一种可恢复机制，是对存档信息的封装；
 * 会占用更多资源；
 * 对比：备忘录模式和状态模式。
 */
public class Test {

    public static void main(String[] args) {
        ArticleMementoManager articleMementoManager = new ArticleMementoManager();

        Article article = new Article("设计模式", "设计模式课程", "test");
        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);
        System.out.println("修改前：" + article);

        article.setTitle("Java");
        article.setContent("Java 课程");
        article.setImgs("test.test");
        System.out.println("修改后：" + article);

        article.undoFromMemento(articleMementoManager.getMemento());
        System.out.println("修改恢复：" + article);
    }

}
