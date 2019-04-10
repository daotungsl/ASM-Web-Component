package com.asm.java.model;

import com.asm.java.data.DataConnectionHelper;
import com.asm.java.entity.Feedback;
import com.asm.java.entity.User;
import com.asm.java.security.Security;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class UserModels {
    DataConnectionHelper data = new DataConnectionHelper();
    Security security = new Security();

    public User addUser(String username, String password, int role, int status){
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        String salt = security.eandomString();
        User user = new User();
        user.setUsername(username);
        user.setPassword(security.endcodeMd5(password) + security.endcodeMd5(salt));
        user.setSalt(security.endcodeMd5(salt));
        user.setRole(role);
        user.setStatus(status);

        String sql = "INSERT INTO users(username, password, salt, role, status) VALUE (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSalt());
            ps.setInt(4, user.getRole());
            ps.setInt(5, user.getStatus());
            ps.executeUpdate();
            System.out.println(new java.util.Date() + " - LOG : Add user " + user.getUsername() + " success!");
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return user;
    }



    public ArrayList<User> getListUser(){
        ArrayList<User> listUsers = new ArrayList<>();
        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
                listUsers.add(user);
            }
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }
        return listUsers;
    }


    public User getUserByUserName(String username){
        User user = new User();

        Connection connection = data.getConnecttion();
        if (connection == null){
            return null;
        }
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSalt(rs.getString("salt"));
                user.setRole(rs.getInt("role"));
                user.setStatus(rs.getInt("status"));
            }
        } catch (SQLException e) {
            System.out.println(new Date() + " - LOG : Sorry! Can't connect to database. Please try again!");
            e.printStackTrace();
        }

        return user;
    }

}
