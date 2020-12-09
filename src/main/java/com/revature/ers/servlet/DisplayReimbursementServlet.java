package com.revature.ers.servlet;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class DisplayReimbursementServlet extends HttpServlet {
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        int reimb_id = Integer.parseInt(req.getParameter("id"));
        Arrays.stream(req.getParameterValues("id")).forEach(i->pw.print(String.format("Reimbursement Found: %s<br>", reimbursementQueryService.getReimbursementFromId(Integer.parseInt(i)))));
        /*Reimbursement reimbursement = reimbursementQueryService.getReimbursementFromId(reimb_id);
        pw.print(String.format("<h3>Reimbursement found with id %d: <br>%s</h3>", reimb_id, reimbursement));
        pw.println("<h1>HELLO!</h1>");*/
        resp.setStatus(200);
    }
}
