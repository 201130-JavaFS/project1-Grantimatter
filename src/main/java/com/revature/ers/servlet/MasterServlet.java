package com.revature.ers.servlet;

import com.revature.ers.controller.LoginController;
import com.revature.ers.controller.ReimbursementController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterServlet extends HttpServlet {

    private ReimbursementController reimbursementController = new ReimbursementController();
    private LoginController loginController = new LoginController();

    Logger log = Logger.getLogger(MasterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setStatus(404);

        final String URI = req.getRequestURI().replace("/project-1/","").toLowerCase();
        log.info("URI: " + URI);

        switch(URI){
            case "reimbursements":
                reimbursementController.reimbursements(req, resp);
                break;
            case "login":
                loginController.login(req, resp);
                break;
            case "logout":
                loginController.logout(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

