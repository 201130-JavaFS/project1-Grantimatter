package com.revature.ers.service.impl;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ReimbursementQueryServiceImplTest {
    Logger log = LogManager.getLogger(ReimbursementQueryServiceImplTest.class);

    UserQueryService userQueryService = new UserQueryServiceImpl();
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    @Test
    void testGetReimbursementsFromAuthor() {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            User grant = userQueryService.getUserFromLogin("grant.wiswell","password");
            if(grant != null){
                reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(grant.getId());
            }
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        //assert(reimbursementList.size() > 0);

        for (Reimbursement r:reimbursementList) {
            log.info(r);
        }

       // Reimbursement newReimbursement = reimbursementQueryService.getReimbursementFromId(62);
       // log.info(String.format("Reimbursement found with id %d %s", newReimbursement.getId(), newReimbursement));
    }

    @Test
    void testGetReimbursementsFromStatus(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementFromStatus(0);
        assert(reimbursementList.size() > 0);
    }

    @Test
    void testGetAllReimbursements(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();
        //assert(reimbursementList.size() > 0);
        for(Reimbursement r:reimbursementList){
            log.info(String.format("ALL REIMBURSEMENTS: %S", reimbursementList));
        }
    }
}