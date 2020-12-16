package com.revature.ers.servlet.pages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomePage extends HttpServlet {

    Logger log = LogManager.getLogger(HomePage.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rq = req.getRequestDispatcher("pages/home.html");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(new User(0,"grant.wiswell","grant","wiswell","grant.wiswell@revature.net"));
        log.info("User Json: " + json);
        resp.getWriter().write(json);
        rq.forward(req, resp);
    }
}
