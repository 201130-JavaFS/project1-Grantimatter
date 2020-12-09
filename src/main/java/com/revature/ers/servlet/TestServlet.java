package com.revature.ers.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TestServlet extends HttpServlet {

    /*
     *  We are overriding the doGet() method so the service method of our servlet will
     *  delegate here if it receives a GET request.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // A print writer created from the response will write to that response object.
        // We can use this to write HTML directly.
        PrintWriter pw = resp.getWriter();
        pw.print("<h1>Hello from doGet()</h1>");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");

        pw.println("<h1>Hello from doPost()</h1>");
        if(name.length() > 0){
            pw.println(String.format("<p>Name: %s</p>", name));
        }*/
        resp.setStatus(200);
    }
}
