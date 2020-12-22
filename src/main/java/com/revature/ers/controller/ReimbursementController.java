package com.revature.ers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.model.dto.ReimbursementDTO;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReimbursementController {

    static Logger log = LogManager.getLogger(ReimbursementController.class);
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    public void reimbursements(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getMethod().equalsIgnoreCase("GET")) {
            log.info("GET Reimbursement request received");
            doGet(req, resp);
        }else if(req.getMethod().equalsIgnoreCase("POST")){
            log.info("POST Reimbursement request received");
            doPost(req, resp);
        }else if(req.getMethod().equalsIgnoreCase("PUT")){
            log.info("PUT Reimbursement request received");
            doPut(req, resp);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        List<String> commandList = new ArrayList<>(Arrays.asList(req.getRequestURI().split("/")));
        commandList.removeAll(Arrays.asList("", null));
        commandList.remove(0);
        commandList.remove(0);
        if(commandList.size() > 0){
            try{
                switch (commandList.get(0)) {
                    case "all":
                        getAllReimbursements(req, resp);
                        break;
                    default:
                        if(commandList.size() > 0){
                            try{
                                int id = Integer.parseInt(commandList.get(0));
                                if(id > 0){
                                    getReimbursementFromId(req, resp, id);
                                }
                            } catch (NumberFormatException e) {
                                log.error(e.getMessage(), e);
                            }
                        }
                        break;
                }
            } catch (IOException e) {
                log.warn(e.getMessage(), e);
            }
        }
    }

    private void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            createNewReimbursement(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doPut(HttpServletRequest req, HttpServletResponse resp){
        log.info("Putting Reimbursements!");
        try{
            User user = SessionUtil.getUserFromSession(req);
            String requestBody = RequestUtil.ReadRequestBody(req);
            ReimbursementDTO reimbursementDTO = objectMapper.readValue(requestBody, ReimbursementDTO.class);
            log.info("ReimbursementDTO received: " + reimbursementDTO);
            if(reimbursementDTO != null){
                for(int id: reimbursementDTO.getIdList()) {
                    updateReimbursement(req, resp, id, reimbursementDTO.getNewStatus());
                }

                resp.getWriter().write("{\"status\":\"success\"}");
                resp.setStatus(200);
            }
        } catch (ErsException | IOException e) {
            log.warn(e.getMessage(), e);
        }
    }

    private void createNewReimbursement(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("Creating new Reimbursement!");
        User user = SessionUtil.getUserFromSession(req);
        ReimbursementDTO reimbursementDTO = new ObjectMapper().readValue(RequestUtil.ReadRequestBody(req), ReimbursementDTO.class);
        int type_id = 0;
        Reimbursement reimbursement = new Reimbursement(reimbursementDTO.amount, reimbursementDTO.getType_id(), user.getId(), reimbursementDTO.getDescription());
        reimbursement.setAuthor(user.getEmail());
        log.info(String.format("New Reimbursement: %s", reimbursement));
        if(user != null && reimbursement != null){
            if(reimbursement.getAuthor() == user.getEmail() || user.getRole_id() == 1){
                boolean created = false;
                if(reimbursement.getDescription() != null && reimbursement.getDescription().length() > 0){
                    created = updateReimbursementService.createReimbursement(reimbursement);
                }else{
                    created = updateReimbursementService.createReimbursementMin(reimbursement);
                }

                if(created){
                    log.info(String.format("New Reimbursement Created for User %s: %d", user.getEmail(), reimbursement.getId()));
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
        if(user != null && user.getRole_id() == 1){
            List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();

            if(reimbursementList.size() > 0){
                String json = objectMapper.writeValueAsString(reimbursementList);
                resp.getWriter().write(json);
                resp.setStatus(200);
            }else{
                resp.setStatus(204);
            }
        }else if (user != null && user.getRole_id() != 1){
            resp.setStatus(403);
        }else{
            resp.setStatus(401);
        }
    }

    public void getReimbursementFromId(HttpServletRequest req, HttpServletResponse resp, int requestedId){
        User user = SessionUtil.getUserFromSession(req);
        if(user != null){
            log.info(String.format("Getting reimbursement with loggedin user: %s", user.getEmail()));

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                if(user.getId() == requestedId || user.getRole_id() == 1){
                    List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(requestedId);
                    for(Reimbursement r:reimbursementList){
                        log.info(String.format("Reimbursement #%d", r.getId()));
                    }
                    String json = objectMapper.writeValueAsString(reimbursementList);
                    log.info(String.format("%d reimbursement requests found for user with ID #%d", reimbursementList.size(), requestedId));
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

    public void updateReimbursement(HttpServletRequest req, HttpServletResponse resp, int id, String newStatus){
        try{
            User user = SessionUtil.getUserFromSession(req);
            if(user != null && user.getRole_id() == 1){
                Reimbursement reimbursement = reimbursementQueryService.getReimbursementFromId(id);
                if(reimbursement.getAuthor() != user.getEmail()) {
                    reimbursement.setResolver_id(user.getId());

                    if(newStatus.equalsIgnoreCase("approved")){
                        updateReimbursementService.approveReimbursement(reimbursement);
                    }else if(newStatus.equalsIgnoreCase("denied")){
                        updateReimbursementService.denyReimbursement(reimbursement);
                    }

                    resp.setStatus(200);
                }else{
                    log.info("User tried resolving their own request");
                    resp.setStatus(403);
                }
            }
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }

    }
}
