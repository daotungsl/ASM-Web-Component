package com.asm.java.data;

import com.asm.java.entity.Feedback;
import com.asm.java.entity.User;
import com.asm.java.model.UserModels;
import com.asm.java.security.Security;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateTableInDatabase {
    public static void main(String[] args) {
        // Khởi tạo chuỗi thông báo và class Security
        String createdtable = "CREATED TABLE SUCCESS !";
        Security security = new Security();

        DataConnectionHelper data = new DataConnectionHelper();
        List<Object> list = new ArrayList<>();
        list.add(new User());
        list.add(new Feedback());
        data.createTable(list, data.getConnecttion());

        // Ghi hoạt động vào log.txt
        System.out.println(new Date() + " - LOG : " + createdtable);
        security.writeLog(createdtable);

        // Dữ liệu mẫu cho 1 tài khoản Admin
        UserModels userModels = new UserModels();
        userModels.addUser("Admin", "Admin", 1, 1);

    }
}
