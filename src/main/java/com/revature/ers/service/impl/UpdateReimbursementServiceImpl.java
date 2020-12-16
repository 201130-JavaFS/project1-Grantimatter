package com.revature.ers.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dao.UpdateReimbursementDao;
import com.revature.ers.dao.impl.UpdateReimbursementDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.util.ReadRequest;
import com.revature.ers.servlet.util.SessionUtil;
import com.revature.ers.servlet.util.UserUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UpdateReimbursementServiceImpl implements UpdateReimbursementService {
    Logger log = LogManager.getLogger(UpdateReimbursementServiceImpl.class);
    UpdateReimbursementDao updateReimbursementDao = new UpdateReimbursementDaoImpl();
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public boolean createReimbursementMin(Reimbursement reimbursement) throws ErsException {
        try{
            log.info("New Reimbursement! " + reimbursement);
            return updateReimbursementDao.createReimbursementMin(reimbursement);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean createReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            log.info("New Reimbursement! " + reimbursement);
            return updateReimbursementDao.createReimbursement(reimbursement);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean approveReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            return updateReimbursementDao.approveReimbursement(reimbursement);
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean denyReimbursement(Reimbursement reimbursement) throws ErsException {
        try{
            return updateReimbursementDao.denyReimbursement(reimbursement);
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
