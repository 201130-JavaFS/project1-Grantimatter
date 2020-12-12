package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;
import com.revature.ers.servlet.util.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReceiveReimbursementServlet extends HttpServlet {

    static Logger log = Logger.getLogger(ReceiveReimbursementServlet.class);
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserUtil.getUserFromSession(req.getSession());
        if(user != null) {
            resp.setContentType("application/json");
            String json = objectMapper.writeValueAsString(reimbursementQueryService.getReimbursementsFromAuthor(user.getId()));

            if (json.length() > 0) {
                resp.getWriter().print(json);
                resp.setStatus(200);
            } else {
                resp.setStatus(204);
            }
        }else{
            log.warn("No user");
            resp.setStatus(401);
        }
    }
}
