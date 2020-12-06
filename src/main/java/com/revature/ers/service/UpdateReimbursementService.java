package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

public interface UpdateReimbursementService {
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException;
}
