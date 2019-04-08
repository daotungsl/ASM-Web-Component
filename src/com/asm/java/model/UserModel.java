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
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root$password= ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean insertUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Account(user)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
