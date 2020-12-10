package com.revature.ers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter pw = resp.getWriter();
        // Will send to home screen
        //deleteCookies(resp);
        resp.addCookie(new Cookie("LoggedUser", ""));
        resp.addCookie(new Cookie("UserId", ""));
        resp.addCookie(new Cookie("UserFullName", ""));
        resp.sendRedirect("home");
        resp.setStatus(200);
    }

    void deleteCookies(HttpServletResponse resp){

    }
}
