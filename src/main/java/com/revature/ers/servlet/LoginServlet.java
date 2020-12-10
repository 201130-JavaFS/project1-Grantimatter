package com.revature.ers.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            log.info("Json User: " + json);

            RequestDispatcher rd = null;

            if(user != null){
                resp = createUserCookies(resp, user);
                resp.sendRedirect("home");
            }else{
                rd = req.getRequestDispatcher("home");
                rd.include(req, resp);
            }
        }
    }

    private HttpServletResponse createUserCookies(HttpServletResponse resp, User user){
        Cookie userCookie = new Cookie("LoggedUser", user.getUsername());
        userCookie.setDomain("localhost");
        userCookie.setComment("This is the currently logged in user");
        resp.addCookie(userCookie);
        Cookie userIdCookie = new Cookie("UserId", Integer.toString(user.getId()));
        userIdCookie.setDomain("localhost");
        userIdCookie.setComment("This is the logged in user's id");
        resp.addCookie(userIdCookie);
        Cookie userFullName = new Cookie("UserFullName", String.format("%s_%s", user.getFirst_name(), user.getLast_name()));
        userFullName.setDomain("localhost");
        userFullName.setComment("This is the name of the logged in user");
        resp.addCookie(userFullName);
        return resp;
    }
}
