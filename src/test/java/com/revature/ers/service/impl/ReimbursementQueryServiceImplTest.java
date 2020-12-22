package com.revature.ers.service.impl;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class ReimbursementQueryServiceImplTest {
    Logger log = LogManager.getLogger(ReimbursementQueryServiceImplTest.class);

    UserQueryService userQueryService = new UserQueryServiceImpl();
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    @Test
    void testGetReimbursementsFromId(){
        try{
            Reimbursement reimbursement = reimbursementQueryService.getReimbursementFromId(48);
            assertNotNull(reimbursement);
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    void testGetReimbursementsFromAuthor() {
        try{
            User grant = userQueryService.getUserFromLogin("grant.wiswell","password");
            if(grant != null){
                List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(grant.getId());
                for (Reimbursement r:reimbursementList) {
                    assertNotNull(r);
                    log.info(r);
                }
            }
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }

        List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(1);
    }

    @Test
    void testGetReimbursementsFromStatus(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getReimbursementFromStatus(0);
        List<Reimbursement> reimbursementListFail = reimbursementQueryService.getReimbursementFromStatus(9);
        assertNotNull(reimbursementList);
        assertEquals(reimbursementListFail, new ArrayList<>());
    }

    @Test
    void testGetAllReimbursements(){
        List<Reimbursement> reimbursementList = reimbursementQueryService.getAllReimbursements();
        assert(reimbursementList.size() > 0);
        for(Reimbursement r:reimbursementList){
            assertNotNull(r);
            log.info(String.format("ALL REIMBURSEMENTS: %S", r));
        }
    }
}