package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

import javax.servlet.http.HttpServletRequest;

public interface UpdateReimbursementService {
    public boolean createReimbursementMin(Reimbursement reimbursement) throws ErsException;
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean approveReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean denyReimbursement(Reimbursement reimbursement) throws ErsException;
}
