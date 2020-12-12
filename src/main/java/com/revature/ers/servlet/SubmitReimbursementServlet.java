package com.revature.ers.servlet;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.UpdateReimbursementServiceImpl;
import com.revature.ers.servlet.util.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitReimbursementServlet extends HttpServlet {

    Logger log = Logger.getLogger(SubmitReimbursementServlet.class);
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            user = UserUtil.getUserFromSession(req.getSession());
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }

        if (user != null) {
            updateReimbursementService.createReimbursement(req);
            resp.setStatus(201);
            resp.sendRedirect("reimbursements");
        }else{
            log.warn("No user logged in");
            resp.setStatus(402);
        }
    }
}
