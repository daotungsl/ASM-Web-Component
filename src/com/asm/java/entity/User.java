package com.asm.java.entity;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private List<Feedback> feedbackList;
    private int role;
    private int status;

    public User() {
    }

    public User(String username, String password, List<Feedback> feedbackList, int role, int status) {
        this.username = username;
        this.password = password;
        this.feedbackList = feedbackList;
        this.role = role;
        this.status = status;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
