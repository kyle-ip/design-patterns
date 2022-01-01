package com.ywh.design.pattern.behavioral.Memento;

import lombok.Data;

/**
 * 手记类
 *
 * @author ywh
 * @since 2019/1/12
 */
@Data
public class Article {

    private String title;

    private String content;

    private String imgs;

    public Article(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public ArticleMemento saveToMemento() {
        return new ArticleMemento(this.title, this.content, this.imgs);
    }

    public void undoFromMemento(ArticleMemento articleMemento) {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.imgs = articleMemento.getImags();
    }

    @Override
    public String toString() {
        return "Article{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", imgs='" + imgs + '\'' +
            '}';
    }
}
