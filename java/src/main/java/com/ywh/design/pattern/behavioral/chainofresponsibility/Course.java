package com.ywh.design.pattern.behavioral.chainofresponsibility;

/**
 * 课程类
 *
 * @author ywh
 * @since 2019/1/12
 */
public class Course {

    private String name;

    private String article;

    private String video;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
