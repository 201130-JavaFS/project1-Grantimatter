package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserQueryService userQueryService = new UserQueryServiceImpl();
    private ObjectMapper objectMapper = new ObjectMapper();

    static Logger log = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("employeeEmail");
        String password = req.getParameter("employeePassword");

        if(username != null && username.length() > 0 && password != null && password.length() > 0){
            User user = userQueryService.getUserFromLogin(username, password);
            String json = objectMapper.writeValueAsString(user);

            RequestDispatcher rd = null;

            if(user != null){
                setupSession(req, resp, user);
                //resp = createUserCookies(resp, user);
                resp.sendRedirect("reimbursements");
            }else{
                rd = req.getRequestDispatcher("home");
                rd.include(req, resp);
            }
        }
    }

    private void setupSession(HttpServletRequest req, HttpServletResponse resp, User user){
        HttpSession session = req.getSession();
        session.setAttribute("username", user.getUsername());
        session.setAttribute("user_email", user.getEmail());
        session.setAttribute("user_id", user.getId());
        session.setAttribute("user_role_id", user.getRole_id());
        session.setAttribute("user_first_name", user.getFirst_name());
        session.setAttribute("user_last_name", user.getLast_name());
    }
}
