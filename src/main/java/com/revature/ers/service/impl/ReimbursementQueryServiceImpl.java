package com.revature.ers.service.impl;

import com.revature.ers.dao.ReimbursementQueryDao;
import com.revature.ers.dao.impl.ReimbursementQueryDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementQueryServiceImpl implements ReimbursementQueryService {
    Logger log = Logger.getLogger(ReimbursementQueryServiceImpl.class);
    ReimbursementQueryDao reimbursementQueryDao = new ReimbursementQueryDaoImpl();

    @Override
    public List<Reimbursement> getReimbursementsFromAuthor(int author_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = reimbursementQueryDao.getReimbursementsFromAuthor(author_id);
        } catch (ErsException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }
}
