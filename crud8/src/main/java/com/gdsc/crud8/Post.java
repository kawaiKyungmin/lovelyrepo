package com.gdsc.crud8;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    public Post() {
    }

    public Post(String id,String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Id
    private String id;

    private String title;

    private String content;
}
