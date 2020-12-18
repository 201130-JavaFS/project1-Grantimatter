package com.revature.ers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import com.revature.ers.model.dto.LoginDTO;
import com.revature.ers.model.dto.UserDTO;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import com.revature.ers.servlet.util.RequestUtil;
import com.revature.ers.servlet.util.SessionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController {

    static Logger log = LogManager.getLogger(LoginController.class);
    UserQueryService userQueryService = new UserQueryServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        log.info("Attempting login");

        if (req.getMethod().equalsIgnoreCase("POST")) {
            String body = RequestUtil.ReadRequestBody(req);
            log.info("Request Body: " + body);

            LoginDTO loginDTO = objectMapper.readValue(body, LoginDTO.class);
            User user = userQueryService.getUserFromLogin(loginDTO.username, loginDTO.password);
            String loggedIn = "{\"loggedUser\":\"" + user.getFirst_name() + "_" + user.getLast_name() + "\"}";

            if (user != null) {
                SessionUtil.setupLoginSession(req, user);
                String name = String.format("%s_%s", user.getFirst_name(), user.getLast_name()).trim();

                log.info(loggedIn);
                resp.getWriter().write(loggedIn);
                resp.setStatus(200);
            } else {
                resp.setStatus(401);
            }
        } else if (req.getMethod().equalsIgnoreCase("GET")) {
            HttpSession session = req.getSession(false);

            if(session != null){
                User user = SessionUtil.getUserFromSession(req);
                if(user != null){
                    UserDTO userDTO = new UserDTO(String.format("%s_%s", user.getFirst_name(), user.getLast_name()), user.getRole_id(), user.getId());
                    //String loggedUser = String.format("{\"loggedUser\":\"%s_%s\", \"role\":\"%s\"}", user.getFirst_name(), user.getLast_name(), user.getRole_id());
                    String userJson = objectMapper.writeValueAsString(userDTO);
                    log.info("userJson: " + userJson);
                    resp.getWriter().write(userJson);
                    resp.setStatus(200);
                }
            }else{
                resp.setStatus(401);
            }
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        resp.addCookie(new Cookie("loggedName", null));
        req.getSession(false).invalidate();
    }
}
