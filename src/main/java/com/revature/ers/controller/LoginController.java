package com.revature.ers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.model.dto.LoginDTO;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import com.revature.ers.servlet.util.RequestUtil;
import com.revature.ers.servlet.util.SessionUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController {

    static Logger log = Logger.getLogger(LoginController.class);
    UserQueryService userQueryService = new UserQueryServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        log.info("Attempting login");

        if(req.getMethod().equalsIgnoreCase("POST")){
            String body = RequestUtil.ReadRequestBody(req);
            ObjectMapper objectMapper = new ObjectMapper();
            LoginDTO loginDTO = objectMapper.readValue(body, LoginDTO.class);
            User user = userQueryService.getUserFromLogin(loginDTO.username, loginDTO.password);

            if(user != null){
                SessionUtil.setupLoginSession(req, user);
                resp.getWriter().write("Login Successful!");
                log.info("User logged in: " + user);
                resp.setStatus(200);
            }else{
                resp.setStatus(401);
            }
        }else if(req.getMethod().equalsIgnoreCase("GET")){

        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession(false).invalidate();
    }
}
