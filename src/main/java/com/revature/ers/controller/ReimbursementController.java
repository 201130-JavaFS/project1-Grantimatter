package com.revature.ers.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;
import com.revature.ers.service.impl.UpdateReimbursementServiceImpl;
import com.revature.ers.servlet.util.RequestUtil;
import com.revature.ers.servlet.util.SessionUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReimbursementController {

    static Logger log = LogManager.getLogger(ReimbursementController.class);
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    public void reimbursements(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getMethod().equalsIgnoreCase("GET")) {
            doGet(req, resp);
        }else if(req.getMethod().equalsIgnoreCase("POST")){
            doPost(req, resp);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        String URI = req.getRequestURI().replace("reimbursements", "").toLowerCase();
        try{
            switch (URI) {
                case "all":
                    getAllReimbursements(req, resp);
                    break;
                default:
                    getReimbursementFromId(req, resp);
                    break;
            }
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }
    }

    private void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            createNewReimbursement(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Creating new Reimbursement!");
        User user = SessionUtil.getUserFromSession(req);
        Reimbursement reimbursement = new ObjectMapper().readValue(RequestUtil.ReadRequestBody(req), Reimbursement.class);
        if(user != null && reimbursement != null){
            if(reimbursement.getAuthor_id() == user.getId() || user.getRole_id() == 0){
                boolean created = false;
                if(reimbursement.getDescription() != null && reimbursement.getDescription().length() > 0){
                    created = updateReimbursementService.createReimbursement(reimbursement);
                }else{
                    created = updateReimbursementService.createReimbursementMin(reimbursement);
                }

                if(created){
                    log.info(String.format("New Reimbursement Created: %s", reimbursement));
                    resp.setStatus(201);
                }else{
                    resp.setStatus(200);
                }
            }else{
                resp.setStatus(403);
            }
        }else{
            resp.setStatus(401);
        }
    }

    public void getAllReimbursements(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = SessionUtil.getUserFromSession(req);
        log.info("Attempting to grab all reimbursements");
        if(user != null && user.getRole_id() == 0){
            List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();
            String json = objectMapper.writeValueAsString(reimbursementList);

            resp.getWriter().write(json);
            resp.setStatus(200);
        }else if (user != null && user.getRole_id() != 1){
            resp.setStatus(403);
        }else{
            resp.setStatus(401);
        }

    }

    public void getReimbursementFromId(HttpServletRequest req, HttpServletResponse resp){
        User user = SessionUtil.getUserFromSession(req);
        log.info("Getting reimbursement with loggedin user: " + user);
        if(user != null){
            try {
                String requestBody = RequestUtil.ReadRequestBody(req);
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode parent = objectMapper.readTree(requestBody);
                int requestedUserId = parent.path("requestedUserId").asInt();
                if(user.getId() == requestedUserId || user.getRole_id() == 0){
                    String json = objectMapper.writeValueAsString(reimbursementQueryService.getReimbursementsFromAuthor(requestedUserId));
                    log.info(String.format("Reimbursements from User with ID #%d\n%s", requestedUserId, json));
                    resp.getWriter().write(json);
                    resp.setStatus(200);
                }else{
                    log.info("User tried viewing reimbursements that they are not allowed to");
                    resp.setStatus(403);
                }
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }else{
            resp.setStatus(401);
        }
    }

    public void getReimbursementsFromAuthor(int author_id){
        reimbursementQueryService.getReimbursementsFromAuthor(author_id);
    }

    public void getReimbursementsFromResolver(int resolver_id){

    }
}
