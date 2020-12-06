package com.revature.ers.dao.impl;

import com.revature.ers.dao.ReimbursementQueryDao;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.impl.util.ReimbursementUtil;
import com.revature.ers.dao.queries.ReimbursementQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ReimbursementQueryDaoImpl implements ReimbursementQueryDao {
    Logger log = Logger.getLogger(ReimbursementQueryDaoImpl.class);

    @Override
    public List<Reimbursement> getReimbursementsFromAuthor(int author_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = ReimbursementUtil.getReimbursementsFromResultSet(Queries.sendQuery(ReimbursementQueries.GET_REIMBURSEMENT_FROM_AUTHOR_ID, author_id));
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return reimbursementList;
    }
}
