package com.ywh.design.pattern.behavioral.Memento;

import lombok.Data;

/**
 * 手记快照类
 *
 * @author ywh
 * @since 2019/1/12
 */
@Data
public class ArticleMemento {

    private String title;

    private String content;

    private String imags;

    public ArticleMemento(String title, String content, String imags) {
        this.title = title;
        this.content = content;
        this.imags = imags;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
            "title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", imags='" + imags + '\'' +
            '}';
    }
}
