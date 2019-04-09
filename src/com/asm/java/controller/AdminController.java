package com.asm.java.controller;

import com.asm.java.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AdminController extends HttpServlet {
    UserModel userModel = new UserModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("status",1);
        ArrayList<String> listFeedback = userModel.getFeedbackByUserId(1);
        req.setAttribute("listfeedback",listFeedback);
        req.getRequestDispatcher("/admin.jsp").forward(req,resp);

    }
}
