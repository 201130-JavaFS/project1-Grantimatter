package com.revature.ers.dao;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

public interface UpdateReimbursementDao {
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException;
}
