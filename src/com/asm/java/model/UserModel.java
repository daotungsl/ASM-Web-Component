package com.asm.java.model;

import com.asm.java.entity.Feedback;
import com.asm.java.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserModel {
    private Connection connection;

     {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/asm_web_component?user=root$password= ");

        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean insertUser(User user){
//        try {
////            PreparedStatement preparedStatement = connection.prepareStatement("insert into Account(user) ");
////            preparedStatement.execute();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        System.out.println("ngon lành "+ user.getUsername());
        return true;
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


    public User getUserByUserNameAndPassword(String username, String password){
        try {
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
            User user = new User("daotung", "123",1,1);
            return user;
        } catch (Exception e) {
            System.out.println("SQLException " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
