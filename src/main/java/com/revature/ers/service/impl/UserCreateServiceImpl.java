package com.revature.ers.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import com.revature.ers.service.UserCreateService;
import com.revature.ers.service.impl.util.ReadRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class UserCreateServiceImpl implements UserCreateService {

    Logger log = LogManager.getLogger(UserCreateServiceImpl.class);

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean createNewUser(HttpServletRequest req) throws ErsException {
        try{
            String body = ReadRequest.getBody(req);
            User user = objectMapper.readValue(body, User.class);

        } catch (ErsException | IOException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }
}
