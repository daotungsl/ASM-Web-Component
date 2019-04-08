package com.asm.java.model;

import com.asm.java.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {
    private Connection connection;
    {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/asm_web_component?user=root$password= ");
        }catch (SQLException e){
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

}
