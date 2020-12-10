package com.revature.ers.service.impl;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UpdateReimbursementService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class UpdateReimbursementServiceImplTest {
    Logger log = Logger.getLogger(UpdateReimbursementServiceImplTest.class);

    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    @Test
    void testCreateReimbursement() {
/*
        Reimbursement reimbursement = new Reimbursement(123.42,0, 2);
        boolean successful =  updateReimbursementService.createReimbursement(reimbursement);

        if(successful){
            log.info("Create reimbursement successful: " + reimbursement);
        }
        */

    }

    @Test
    void testApproveReimbursement(){
        Reimbursement newReimbursement = reimbursementQueryService.getReimbursementFromId(9);
        //log.info(String.format("Approve Reimbursement Successful? %s", updateReimbursementService.approveReimbursement(newReimbursement) ? "Yes!" : "No!"));;
    }

    @Test
    void testDenyReimbursement(){
        Reimbursement newReimbursement = reimbursementQueryService.getReimbursementFromId(11);
        //log.info(String.format("Deny Reimbursement Successful? %s", updateReimbursementService.denyReimbursement(newReimbursement) ? "Yes!" : "No!"));
    }
}