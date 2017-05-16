package com.cognifide.akaitraining.blog;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by szymon.nowak on 16.05.2017.
 */
public class BlogModel {
    private String title;
    private String author;
    private String date;
    private String content;

    public BlogModel(String title, String author, String content, String date) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    public BlogModel(String title, String author, String content) {
        this(title, author, content, new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
