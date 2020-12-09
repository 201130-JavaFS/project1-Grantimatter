package com.revature.ers.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SuccessServlet extends HttpServlet {

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
        pw.print(String.format("<h2>Welcome %s!</h2>", req.getParameter("employeeEmail")));
        pw.print(String.format("<a class='button btn-primary' href='logout'>Logout"));
    }

}
