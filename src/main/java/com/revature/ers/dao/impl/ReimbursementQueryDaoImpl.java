package com.revature.ers.dao.impl;

import com.revature.ers.dao.ReimbursementQueryDao;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.impl.util.ReimbursementUtil;
import com.revature.ers.dao.queries.ReimbursementQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.util.sorting.SubmittedComparator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReimbursementQueryDaoImpl implements ReimbursementQueryDao {
    Logger log = Logger.getLogger(ReimbursementQueryDaoImpl.class);

    @Override
    public Reimbursement getReimbursementFromId(int reimb_id) throws ErsException {
        Reimbursement reimbursement = null;
        try{
            reimbursement = ReimbursementUtil.getNextReimbursementFromResultSet(Queries.sendQuery(ReimbursementQueries.GET_REIMBURSEMENT_FROM_ID, reimb_id));
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return reimbursement;
    }

    @Override
    public List<Reimbursement> getReimbursementsFromAuthor(int author_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = ReimbursementUtil.getReimbursementsFromResultSet(Queries.sendQuery(ReimbursementQueries.GET_REIMBURSEMENT_FROM_AUTHOR_ID, author_id));
            SubmittedComparator submittedComparator = new SubmittedComparator();
            Collections.sort(reimbursementList, submittedComparator);
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> getReimbursementFromStatus(int status_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = ReimbursementUtil.getReimbursementsFromResultSet(Queries.sendQuery(ReimbursementQueries.GET_REIMBURSEMENT_FROM_STATUS_ID, status_id));
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> getAllReimbursements() throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = ReimbursementUtil.getReimbursementsFromResultSet(Queries.sendQuery(ReimbursementQueries.GET_ALL_REIMBURSEMENTS));
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return reimbursementList;
    }
}
