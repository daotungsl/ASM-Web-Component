package com.asm.java.controller;

import com.asm.java.data.DataConnectionHelper;
import com.asm.java.entity.User;
import com.asm.java.model.UserModels;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("title","Trang đăng kí");
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        DataConnectionHelper data = new DataConnectionHelper();
        data.getConnecttion();

        User user = new User(username,password,0, 1);
        if (!user.isValid()){
            HashMap<String, ArrayList<String>> errors = user.getErrors();
            req.setAttribute("user",user);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        UserModels userModel = new UserModels();
        userModel.addUser(username, password, 0, 1);
        resp.sendRedirect("/login");
    }
}
