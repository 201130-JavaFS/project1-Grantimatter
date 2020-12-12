package com.revature.ers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.ReimbursementQueryServiceImpl;
import com.revature.ers.service.impl.UpdateReimbursementServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReimbursementController {

    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    public void getAllReimbursements(HttpServletResponse resp) throws IOException {
        List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();
        String json = objectMapper.writeValueAsString(reimbursementList);

        resp.getWriter().print(json);
        resp.setStatus(200);
    }

    public void getReimbursementFromId(int id){
        reimbursementQueryService.getReimbursementFromId(id);
    }

    public void getReimbursementsFromAuthor(int author_id){
        reimbursementQueryService.getReimbursementsFromAuthor(author_id);
    }

    public void getReimbursementsFromResolver(int resolver_id){

    }
}
