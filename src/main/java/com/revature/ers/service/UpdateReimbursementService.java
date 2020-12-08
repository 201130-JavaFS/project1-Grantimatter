package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

public interface UpdateReimbursementService {
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean approveReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean denyReimbursement(Reimbursement reimbursement) throws ErsException;
}
