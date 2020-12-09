package com.revature.ers.servlet;

import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    UserQueryService userQueryService = new UserQueryServiceImpl();
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    static Logger log = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("employeeEmail");
        String password = req.getParameter("employeePassword");

        //log.info(String.format("Username: %s Password:%s", username, password));

        RequestDispatcher rd = null;
        PrintWriter pw = resp.getWriter();

        if(username != null && username.length() > 0 && password != null && password.length() > 0){
            User user = userQueryService.getUserFromLogin(username, password);

            if(user != null){
                //pw.println(String.format("User found!<br>%s", user));

                // When getting the request dispatcher I can state the relative path I want to forward to.
                rd = req.getRequestDispatcher("success");
                rd.forward(req, resp);
            }else{
                rd = req.getRequestDispatcher("home");
                rd.include(req, resp);
                pw.print("<span style=\"color:red; text-align:center;\">Invalid Login Credentials</span>");
            }
            //return;
        }

        //resp.setStatus(200);
    }
}
