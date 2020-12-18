package com.revature.ers.service.impl;

import com.revature.ers.dao.ReimbursementQueryDao;
import com.revature.ers.dao.impl.ReimbursementQueryDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.util.sorting.SubmittedComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReimbursementQueryServiceImpl implements ReimbursementQueryService {
    Logger log = LogManager.getLogger(ReimbursementQueryServiceImpl.class);
    ReimbursementQueryDao reimbursementQueryDao = new ReimbursementQueryDaoImpl();

    @Override
    public Reimbursement getReimbursementFromId(int reimb_id) throws ErsException {
        Reimbursement reimbursement = null;
        try{
            reimbursement = reimbursementQueryDao.getReimbursementFromId(reimb_id);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return reimbursement;
    }

    @Override
    public List<Reimbursement> getReimbursementsFromAuthor(int author_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = reimbursementQueryDao.getReimbursementsFromAuthor(author_id);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> getReimbursementFromStatus(int status_id) throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = reimbursementQueryDao.getReimbursementFromStatus(status_id);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return reimbursementList;
    }

    @Override
    public List<Reimbursement> getAllReimbursements() throws ErsException {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            reimbursementList = reimbursementQueryDao.getAllReimbursements();
            SubmittedComparator submittedComparator = new SubmittedComparator();
            Collections.sort(reimbursementList, submittedComparator);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return reimbursementList;
    }
}
