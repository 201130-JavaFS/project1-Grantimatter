package com.revature.ers.service.impl;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public  class UpdateReimbursementServiceImplTest {

    UpdateReimbursementService updateReimbursementService = new UpdateReimbursementServiceImpl();

    @Test
    public void createReimbursementMin() {
        updateReimbursementService.createReimbursementMin(new Reimbursement());
    }

    @Test
    public void createReimbursement() {
        updateReimbursementService.createReimbursement(new Reimbursement());
    }

    @Test
    public void approveReimbursement() {
        updateReimbursementService.approveReimbursement(new Reimbursement());
    }

    @Test
    public void denyReimbursement() {
        updateReimbursementService.denyReimbursement(new Reimbursement());
    }
}