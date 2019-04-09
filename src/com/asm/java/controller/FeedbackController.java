package com.asm.java.controller;

import com.asm.java.entity.Feedback;
import com.asm.java.model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("title","Trang feedback");

        req.getRequestDispatcher("/feedback.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String content = req.getParameter("content");

        Feedback feedback = new Feedback(content);
        System.out.println(content);
        if (!feedback.isValid()){
            HashMap<String, ArrayList<String>> errors = feedback.getErrors();
            req.setAttribute("content",content);
            req.setAttribute("errors",errors);
            HttpSession session = req.getSession();
            session.setAttribute("content", content);

//            resp.sendRedirect("/feedback");

            req.getRequestDispatcher("feedback.jsp").forward(req,resp);
        }
        UserModel userModel = new UserModel();
        userModel.insertFeedback(feedback);
        resp.sendRedirect("/listfeedback");

    }
}
