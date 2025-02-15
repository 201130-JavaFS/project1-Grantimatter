package com.revature.ers.dao.impl;

import com.revature.ers.dao.UpdateReimbursementDao;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.queries.ReimbursementQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateReimbursementDaoImpl implements UpdateReimbursementDao {
    Logger log = LogManager.getLogger(UpdateReimbursementDaoImpl.class);

    @Override
    public boolean createReimbursementMin(Reimbursement reimbursement) throws ErsException {
        try{
            return Queries.sendUpdate(ReimbursementQueries.CREATE_REIMBURSEMENT_MIN, reimbursement.getAmount(), reimbursement.getAuthor_id(), reimbursement.getType_id()) > 0;
        } catch (Exception e) {
            log.error(e);
        }
        return false;
    }

    @Override
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            return Queries.sendUpdate(ReimbursementQueries.CREATE_REIMBURSEMENT, reimbursement.getAmount(), reimbursement.getAuthor_id(), reimbursement.getType_id(), reimbursement.getDescription()) > 0;
        } catch (Exception e) {
            log.error(e);
        }
        return false;
    }

    @Override
    public boolean approveReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            return Queries.sendUpdate(ReimbursementQueries.APPROVE_REIMBURSEMENT, reimbursement.getResolver_id(), reimbursement.getId()) > 0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean denyReimbursement(Reimbursement reimbursement) throws ErsException {
        try {
            return Queries.sendUpdate(ReimbursementQueries.DENY_REIMBURSEMENT, reimbursement.getResolver_id(), reimbursement.getId()) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
