package com.revature.ers.service.impl;

import com.revature.ers.dao.UpdateReimbursementDao;
import com.revature.ers.dao.impl.UpdateReimbursementDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import org.apache.log4j.Logger;

public class UpdateReimbursementServiceImpl implements UpdateReimbursementService {
    Logger log = Logger.getLogger(UpdateReimbursementServiceImpl.class);
    UpdateReimbursementDao updateReimbursementDao = new UpdateReimbursementDaoImpl();

    @Override
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            return updateReimbursementDao.createReimbursement(reimbursement);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }
}
