package com.revature.ers.service.impl;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

 class UpdateReimbursementServiceImplTest {

    Logger log = LogManager.getLogger(UpdateReimbursementServiceImplTest.class);
    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    @Test
    void createReimbursementMin() {
        try {
            boolean success = updateReimbursementService.createReimbursementMin(new Reimbursement());
            assertFalse(success);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
    }

    @Test
    void createReimbursement() {
        try {
            boolean success = updateReimbursementService.createReimbursement(new Reimbursement());
            assertFalse(success);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
    }

    @Test
    void approveReimbursement() {
        boolean success = updateReimbursementService.approveReimbursement(new Reimbursement());
        assertFalse(success);
    }

    @Test
    void denyReimbursement() {
        boolean success = updateReimbursementService.denyReimbursement(new Reimbursement());
        assertFalse(success);
    }
}