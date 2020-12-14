package com.revature.ers.dao;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

public interface UpdateReimbursementDao {
    public boolean createReimbursementMin(Reimbursement reimbursement) throws ErsException;
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean approveReimbursement(Reimbursement reimbursement) throws ErsException;
    public boolean denyReimbursement(Reimbursement reimbursement) throws ErsException;
}
