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

    public boolean insertFeedback(Feedback feedback){


        System.out.println("ngon lành "+ feedback.getContent());
        return true;

    }

    public ArrayList<String> getFeedbackByUserId(int user_id){
        try {
            ArrayList<String> listFeedback = new ArrayList<>();

//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("select * from account where username = ? and password = ?");
//            preparedStatement.setString(1, username);
//            preparedStatement.setString(2, password);
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()){
//                String existUsername = rs.getString(1);
//                String existPassword = rs.getString(2);
//
//                User user = new User("daotung", "123");
//                return user;
//            }
            for (int i = 0; i <10 ; i++) {
                String content = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+i;
                listFeedback.add(content);
                String status = "1";
                listFeedback.add(status);


            }

            return listFeedback;
        } catch (Exception e) {
            System.out.println("SQLException " + e.getMessage());
            e.printStackTrace();
        }
        return null;
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
