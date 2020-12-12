package com.revature.ers.servlet.pages;

import com.revature.ers.model.User;
import com.revature.ers.servlet.util.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementManagementPage extends HttpServlet {

    Logger log = Logger.getLogger(ReimbursementManagementPage.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserUtil.getUserFromSession(req.getSession());

        RequestDispatcher rd = req.getRequestDispatcher("reimbursements");
        rd.include(req, resp);
    }
}
