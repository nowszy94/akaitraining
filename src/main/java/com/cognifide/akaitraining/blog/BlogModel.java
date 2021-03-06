package com.cognifide.akaitraining.blog;

import java.util.Date;

public class BlogModel {
    private String title;
    private String author;
    private Date date;
    private String content;

    public BlogModel(String title, String author, String content, Date date) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public BlogModel(String title, String author, String content) {
        this(title, author, content, new Date());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
