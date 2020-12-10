package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReceiveReimbursementServlet extends HttpServlet {

    static Logger log = Logger.getLogger(ReceiveReimbursementServlet.class);
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("UserId"));
        resp.setContentType("application/json");
        String json = objectMapper.writeValueAsString(reimbursementQueryService.getReimbursementsFromAuthor(userId));

        String uri = req.getRequestURI();
        String possibleId = uri.replace("/project-1/reimbursements/", "");
/*
        int id = 0;
        try {
            id = Integer.parseInt(possibleId);
        } catch (NumberFormatException e) {
            log.warn(e.getMessage(), e);
        }*/
        resp.setContentType("application/json");

        if(json.length() > 0){
            resp.getWriter().print(json);
            resp.setStatus(200);
        }else{
            resp.setStatus(204);
        }
    }
}
