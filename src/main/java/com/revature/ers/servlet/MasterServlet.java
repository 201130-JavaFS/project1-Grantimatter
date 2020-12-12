package com.revature.ers.servlet;

import com.revature.ers.controllers.ReimbursementController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MasterServlet extends HttpServlet {

    private ReimbursementController reimbursementController = new ReimbursementController();

    Logger log = Logger.getLogger(MasterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setStatus(404);

        final String URI = req.getRequestURI().replace("/project-1/","").toLowerCase();

        log.info("URI: " + URI);

        switch(URI){
            case "reimbursements":
                log.info("Reimbursements called");
                reimbursementController.getAllReimbursements(resp);
                break;
            case "login":

                break;
        }
    }
}

