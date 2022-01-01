package com.ywh.design.pattern.behavioral.Memento;

import java.util.Stack;

/**
 * 手记快照管理类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class ArticleMementoManager {

    private final Stack<ArticleMemento> ARTICLE_MEMENTO_STACK= new Stack<ArticleMemento>();

    public ArticleMemento getMemento() {
        return ARTICLE_MEMENTO_STACK.pop();
    }

    public void addMemento(ArticleMemento articleMemento) {
        ARTICLE_MEMENTO_STACK.push(articleMemento);
    }
}
