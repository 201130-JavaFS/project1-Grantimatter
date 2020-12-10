package com.revature.ers.servlet;

import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.UpdateReimbursementServiceImpl;
import com.revature.ers.servlet.util.Cookies;
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
        int userId = -1;

        //String userCookie = Cookies.getCookie(req,"UserId");
        try{
            userId = Integer.parseInt(Cookies.getCookie(req, "UserId"));
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        //Reimbursement newreimb = null;

        if (userId > -1) {
            updateReimbursementService.createReimbursement(req);
            resp.sendRedirect("reimbursements");
        }
    }
}
