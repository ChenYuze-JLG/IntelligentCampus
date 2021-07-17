package com.sevengroup.campus.bean;

import java.io.Serializable;


public class ArticleBean implements Serializable {

    private Integer id ; // 文章ID

    private String author ; // 文章的作者

    private String title ; // 标题

    private String content ; // 文章内容

    public ArticleBean() {
    }

    public ArticleBean(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
