package com.revature.ers.servlet;

import com.revature.ers.controller.LoginController;
import com.revature.ers.controller.ReimbursementController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterServlet extends HttpServlet {

    static ReimbursementController reimbursementController = new ReimbursementController();
    static LoginController loginController = new LoginController();

    static Logger log = LogManager.getLogger(MasterServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info(String.format("Someone's trying to get here! %s", req.getRemoteAddr()));
        resp.setContentType("application/json");
        resp.setStatus(404);

        final String URI = req.getRequestURI();
        List<String> commandList = new ArrayList<>(Arrays.asList(URI.split("/")));
        commandList.removeAll(Arrays.asList("", null));
        commandList.remove(0);
        //String[] commands = URI.split("/");
        for(String c:commandList){
            log.info("Command List: " + c);
        }

        if(commandList.size() > 0){
            switch(commandList.get(0)){
                case "reimbursements":
                    reimbursementController.reimbursements(req, resp);
                    break;
                case "login":
                    loginController.login(req, resp);
                    break;
                case "logout":
                    loginController.logout(req, resp);
                    break;
                default:

                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

