package com.asm.java.controller;

import com.asm.java.entity.User;
import com.asm.java.model.UserModel;

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
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User(username,password);
        if (!user.isValid()){
            HashMap<String, ArrayList<String>> errors = user.getErrors();
            req.setAttribute("title","Trang đăng kí");
            req.setAttribute("user",user);
            req.setAttribute("errors",errors);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        UserModel userModel = new UserModel();
        userModel.insertUser(user);
        resp.getWriter().println("Success");
    }
}
