package com.revature.ers.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
        String body = RequestUtil.ReadRequestBody(req);

        if(body == null || body.length() < 1) {
            resp.setStatus(204);
        }

        if (req.getMethod().equalsIgnoreCase("POST")) {
            LoginDTO loginDTO = null;
            try{
                loginDTO = objectMapper.readValue(body, LoginDTO.class);
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(), e);
                resp.setStatus(400);
                return;
            }
            User user = userQueryService.getUserFromLogin(loginDTO.username, loginDTO.password);

            if (user != null) {
                String loggedIn = "{\"loggedUser\":\"" + user.getFirst_name() + "_" + user.getLast_name() + "\"}";

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
                    String userJson = objectMapper.writeValueAsString(userDTO);
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
