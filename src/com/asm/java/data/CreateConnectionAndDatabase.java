package com.asm.java.data;

import com.asm.java.model.UserModels;
import com.asm.java.security.Security;

import java.sql.Connection;
import java.util.Date;

public class CreateConnectionAndDatabase {
    public static void main(String[] args) {
        // Khởi tạo class Security và DataConnectionHelper
        Security security = new Security();
        DataConnectionHelper dch = new DataConnectionHelper();

        // Mở connectiuon
        Connection connection = dch.getConnecttion();

        // ghi connection vào log
        System.out.println(new Date() + " - LOG : " + connection);
        security.writeLog(connection + "");
    }
}
