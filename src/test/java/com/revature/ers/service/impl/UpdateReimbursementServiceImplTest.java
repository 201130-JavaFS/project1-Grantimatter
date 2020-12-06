package com.revature.ers.service.impl;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateReimbursementServiceImplTest {
    Logger log = Logger.getLogger(UpdateReimbursementServiceImplTest.class);

    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    @Test
    void testCreateReimbursement() {
        Reimbursement reimbursement = new Reimbursement(123.42,0,2);
        //boolean successful =  updateReimbursementService.createReimbursement(reimbursement);
        //log.info("Create reimbursement successful: " + successful);
    }
}