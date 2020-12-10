package com.revature.ers.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SuccessServlet extends HttpServlet {

    static Logger log = Logger.getLogger(SuccessServlet.class);

    // This is bad practice but it is possible
/*
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.print(String.format("<h2>Welcome %s!</h2>", req.getParameter("employeeEmail")));
        pw.print(String.format("<a class='button btn-primary' href='logout'>Logout"));
    }
*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        String userCookie = "";


        resp.sendRedirect("home");
    }

}
