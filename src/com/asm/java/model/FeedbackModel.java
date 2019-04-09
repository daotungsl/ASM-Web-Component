package com.asm.java.model;

import com.asm.java.data.DataConnectionHelper;
import com.asm.java.entity.Feedback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class FeedbackModel {
    DataConnectionHelper data = new DataConnectionHelper();

    public ArrayList<Feedback> getListFeedbacks(){
        ArrayList<Feedback> listFeedbacks = new ArrayList<>();
        Connection connection = data.getConnecttion();
        if (connection==null){
            return null;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT  * FROM feedbacks WHERE status = 1";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setUserId(rs.getInt("userId"));
                feedback.setContent(rs.getString("content"));
                feedback.setCreatedAt(rs.getLong("createdAt"));
                feedback.setUpdatedAt(rs.getLong("updatedAt"));
                feedback.setStatus(rs.getInt("status"));
                listFeedbacks.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return listFeedbacks;
    }

    public ArrayList<Feedback> getListFeedbackByUserId(int id){
        ArrayList<Feedback> listFeedbackByUserId = new ArrayList<>();
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM feedbacks where userId = '" + id + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Feedback feedback = new Feedback();
                feedback.setId(rs.getInt("id"));
                feedback.setUserId(rs.getInt("userId"));
                feedback.setContent(rs.getString("content"));
                feedback.setCreatedAt(rs.getLong("createdAt"));
                feedback.setUpdatedAt(rs.getLong("updatedAt"));
                feedback.setStatus(rs.getInt("status"));
                listFeedbackByUserId.add(feedback);
            }
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return listFeedbackByUserId;
    }

    public Feedback getFeedbackById(int id){
        Feedback feedback = new Feedback();
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM feedbacks WHERE id = '" + id +"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                feedback.setId(rs.getInt("id"));
                feedback.setUserId(rs.getInt("userId"));
                feedback.setContent(rs.getString("content"));
                feedback.setCreatedAt(rs.getLong("createdAt"));
                feedback.setUpdatedAt(rs.getLong("updatedAt"));
                feedback.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return feedback;
    }

    public Feedback updateFeedback(int id, Feedback feedback){
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        if (id != feedback.getId()){
            System.out.println(new Date() + " - LOG : Feedback not found!!");
            return null;
        }
        Date date = new Date();
        long updatedAt = date.getTime();
        String sql = "UPDATE feedbacks SET   content = ?, updatedAt = ?, status = ? WHERE id = '" + id + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, feedback.getContent());
            ps.setLong(2, updatedAt);
            ps.setInt(3, feedback.getStatus());
            ps.executeUpdate();
            System.out.println(new Date() + " - LOG : Update success!");
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        feedback = getFeedbackById(id);
        return feedback;
    }

    public Feedback addFeedback( String content, int userId){
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        Date date = new Date();
        long createdAt = date.getTime();
        long updatedAt = date.getTime();
        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setContent(content);
        feedback.setCreatedAt(createdAt);
        feedback.setUpdatedAt(updatedAt);
        feedback.setStatus(0);

        String sql = "INSERT INTO feedbacks(userId,  content, createdAt, updatedAt, status) VALUE (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, feedback.getUserId());
            ps.setString(2, feedback.getContent());
            ps.setLong(3, feedback.getCreatedAt());
            ps.setLong(4, feedback.getUpdatedAt());
            ps.setInt(5, feedback.getStatus());
            ps.executeUpdate();
            System.out.println(new Date() + " - LOG : Add feedbach +" + feedback.getId() + " success!");
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return feedback;
    }

    public void deleteFeedback(int id){
        Connection connection = data.getConnecttion();
        if (connection == null){
            System.out.println("LOG : Sorry! Can't connect to database. Please try again!");
        }
        if (checkFeedbackExists(id, connection)){
            String sql = "DELETE FROM feedbacks WHERE id = '" + id + "'";
            try {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println(new Date() + " - LOG : Delete user has +" + id + " success!");
            } catch (SQLException e) {
                System.out.println(new Date() + " - LOG : Can't delete user has +" + id );
                e.printStackTrace();
            }
        }
    }

    private boolean checkFeedbackExists(int id, Connection connection){
        if (connection == null){
            return false;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM feedbacks WHERE id = '" + "'";
            ResultSet rs = stmt.executeQuery(sql);
            return (rs.first());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
