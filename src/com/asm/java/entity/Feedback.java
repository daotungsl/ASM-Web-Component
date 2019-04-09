package com.asm.java.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private int id;
    private String content;
    private int user_id;
    private int status;
    HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public Feedback() {
        this.content = "";
    }

    public Feedback(String content) {
        this.content = content;
    }

    public Feedback(String content, int user_id, int status) {
        this.content = content;
        this.user_id = user_id;
        this.status = status;
    }

    public Feedback(int id, String content, int user_id, int status) {
        this.id = id;
        this.content = content;
        this.user_id = user_id;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isValid() {
        validate();
        return this.errors.size() == 0;
    }

    private void validate() {
        if (this.errors == null) {
            this.errors = new HashMap<>();
        }
        ArrayList<String> contentError = this.errors.get("content");

        if (contentError == null) {
            contentError = new ArrayList<>();
        }
        if (this.content == null || this.content.length() == 0) {
            contentError.add("Content is required!!!");
        }
        if (this.content.length() < 10) {
            contentError.add("Content must be greater than 10 characters ");
        }
        if (this.content.length() > 2000) {
            contentError.add("Content must be less than 2000 characters");
        }
        if (contentError.size() > 0) {
            this.errors.put("content",contentError);
        }
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return this.errors;
    }
}
