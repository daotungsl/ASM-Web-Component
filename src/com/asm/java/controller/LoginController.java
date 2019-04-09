package com.asm.java.controller;

import com.asm.java.entity.User;
import com.asm.java.model.UserModels;
import com.asm.java.security.Security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserModels userModel = new UserModels();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = checkLogin(username, password);
        if (user != null) {
            //req.getSession()
            // không ai lưu cookie thế này, ngoài thầy.
            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user.getUsername());
            session.setAttribute("role", user.getRole());
            session.setAttribute("userId", user.getId());
            System.out.println("Logged in sucess !!!");
            if (user.getRole() == 1) {
                resp.sendRedirect("/admin");

            }else {
                resp.sendRedirect("/feedback");
            }
        } else {
            resp.getWriter().println("Sai thông tin tài khoản.");
        }


    }

    private User checkLogin(String username, String password) {
        Security security = new Security();
        User user = userModel.getUserByUserName(username);
        System.out.println(user);
        String passwordLogin= security.endcodeMd5(password)+user.getSalt();
        if (passwordLogin.equals(user.getPassword())){
            return user;
        }
        return null;
    }
}
