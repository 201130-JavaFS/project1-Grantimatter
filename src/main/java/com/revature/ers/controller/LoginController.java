package com.revature.ers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.model.dto.LoginDTO;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import com.revature.ers.servlet.util.RequestUtil;
import com.revature.ers.servlet.util.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController {

    UserQueryService userQueryService = new UserQueryServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getMethod().equalsIgnoreCase("POST")){
            String body = RequestUtil.ReadRequestBody(req);
            ObjectMapper objectMapper = new ObjectMapper();
            LoginDTO loginDTO = objectMapper.readValue(body, LoginDTO.class);
            User user = userQueryService.getUserFromLogin(loginDTO.username, loginDTO.password);

            if(user != null){
                SessionUtil.setupLoginSession(req.getSession(), user);
                resp.setStatus(200);
            }else{

            }
        }
    }
}
