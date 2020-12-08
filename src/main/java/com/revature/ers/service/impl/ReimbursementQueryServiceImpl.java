package com.revature.ers.service.impl;

import com.revature.ers.dao.ReimbursementQueryDao;
import com.revature.ers.dao.impl.ReimbursementQueryDaoImpl;
import com.revature.ers.dao.queries.ReimbursementQueries;
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
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return reimbursementList;
    }
}
