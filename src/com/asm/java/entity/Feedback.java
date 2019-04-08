package com.asm.java.entity;

public class Feedback {
    private int id;
    private String content;
    private int user_id;

    public Feedback() {
    }

    public Feedback(int id, String content, int user_id) {
        this.id = id;
        this.content = content;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
