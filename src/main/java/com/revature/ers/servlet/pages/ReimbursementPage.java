package com.revature.ers.servlet.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ReimbursementPage extends HttpServlet {

    static Logger log = LogManager.getLogger(ReimbursementPage.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("pages/reimbursements.html");
        rq.forward(req, resp);
        doPost(req, resp);
    }
}
