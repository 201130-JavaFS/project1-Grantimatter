package com.revature.ers.service.impl;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ReimbursementQueryServiceImplTest {
    Logger log = LogManager.getLogger(ReimbursementQueryServiceImplTest.class);

    UserQueryService userQueryService = new UserQueryServiceImpl();
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    @Test
    public void testGetReimbursementsFromId(){
        try{
            Reimbursement reimbursement = reimbursementQueryService.getReimbursementFromId(48);
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void testGetReimbursementsFromAuthor() {
        try{
            User grant = userQueryService.getUserFromLogin("grant.wiswell","password");
            if(grant != null){
                List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(grant.getId());
                for (Reimbursement r:reimbursementList) {
                    assert(r != null);
                    log.info(r);
                }
            }
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }

        List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(1);
    }

    @Test
    public void testGetReimbursementsFromStatus(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementFromStatus(0);
        List<Reimbursement> reimbursementListFail = reimbursementQueryService.getReimbursementFromStatus(9);
        //assert(reimbursementListFail == null);
        //assert(reimbursementList.size() > 0);
    }

    @Test
    public void testGetAllReimbursements(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();
        assert(reimbursementList.size() > 0);
        for(Reimbursement r:reimbursementList){
            log.info(String.format("ALL REIMBURSEMENTS: %S", r));
        }
    }
}