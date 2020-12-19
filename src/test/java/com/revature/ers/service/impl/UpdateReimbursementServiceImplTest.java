package com.revature.ers.service.impl;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UpdateReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class UpdateReimbursementServiceImplTest {
    Logger log = LogManager.getLogger(UpdateReimbursementServiceImplTest.class);

    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    /*
    @Test
    void testCreateReimbursement() {

        Reimbursement reimbursement = new Reimbursement(new BigDecimal(123.42).round(new MathContext(2, RoundingMode.CEILING)),0, 2);
        boolean successful = false;
        if(reimbursement.getDescription() != null && reimbursement.getDescription().length() > 0){
            successful =  updateReimbursementService.createReimbursement(reimbursement);
        }else{
            successful = updateReimbursementService.createReimbursementMin(reimbursement);
        }

        if(successful){
            log.info("Create reimbursement successful: " + reimbursement);
        }


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
    }*/
}