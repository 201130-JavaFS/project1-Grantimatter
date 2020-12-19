package com.revature.ers.servlet;

import com.revature.ers.controller.LoginController;
import com.revature.ers.controller.ReimbursementController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterServlet extends HttpServlet {

    static ReimbursementController reimbursementController = new ReimbursementController();
    static LoginController loginController = new LoginController();

    static Logger log = LogManager.getLogger(MasterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("<h1>You're getting something!</h1>");
        resp.setContentType("application/json");
        resp.setStatus(404);

        final String URI = req.getRequestURI().replace("/project-1/","").toLowerCase();
        String[] commands = URI.split("/");

        switch(commands[0]){
            case "reimbursements":
                reimbursementController.reimbursements(req, resp);
                break;
            case "login":
                loginController.login(req, resp);
                break;
            case "logout":
                loginController.logout(req, resp);
                break;
            default:

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

