package com.revature.ers.servlet.pages;

import com.revature.ers.model.User;
import com.revature.ers.servlet.util.SessionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementManagementPage extends HttpServlet {

    Logger log = LogManager.getLogger(ReimbursementManagementPage.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = SessionUtil.getUserFromSession(req);

        RequestDispatcher rd = req.getRequestDispatcher("reimbursements");
        rd.include(req, resp);
    }
}
