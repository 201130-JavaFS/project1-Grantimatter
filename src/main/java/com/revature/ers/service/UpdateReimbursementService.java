package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

import javax.servlet.http.HttpServletRequest;

public interface UpdateReimbursementService {
    public boolean createReimbursement(HttpServletRequest req) throws ErsException;
    public boolean approveReimbursement(HttpServletRequest req) throws ErsException;
    public boolean denyReimbursement(HttpServletRequest req) throws ErsException;
}
