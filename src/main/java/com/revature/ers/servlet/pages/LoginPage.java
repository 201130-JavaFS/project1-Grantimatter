package com.revature.ers.servlet.pages;

import com.revature.ers.model.Reimbursement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("pages/login.html");
        rq.forward(req, resp);
    }
}
