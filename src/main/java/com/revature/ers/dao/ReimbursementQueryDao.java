package com.revature.ers.dao;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;

import java.util.List;

public interface ReimbursementQueryDao {
    public List<Reimbursement> getReimbursementsFromAuthor(int author_id) throws ErsException;

}
