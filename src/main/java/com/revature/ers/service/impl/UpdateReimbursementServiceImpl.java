package com.revature.ers.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dao.UpdateReimbursementDao;
import com.revature.ers.dao.impl.UpdateReimbursementDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.service.UpdateReimbursementService;
import com.revature.ers.service.impl.util.ReadRequest;
import com.revature.ers.servlet.util.UserUtil;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UpdateReimbursementServiceImpl implements UpdateReimbursementService {
    Logger log = Logger.getLogger(UpdateReimbursementServiceImpl.class);
    UpdateReimbursementDao updateReimbursementDao = new UpdateReimbursementDaoImpl();
    ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean createReimbursement(HttpServletRequest req) throws ErsException {
        try{
            String body = ReadRequest.getBody(req);
            Reimbursement reimbursement = objectMapper.readValue(body, Reimbursement.class);
            reimbursement.setAuthor_id(UserUtil.getUserFromSession(req.getSession()).getId());
            log.info("New Reimbursement! " + reimbursement);
            return updateReimbursementDao.createReimbursement(reimbursement);
        } catch (ErsException | IOException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean approveReimbursement(HttpServletRequest req) throws ErsException {
        try{
            return updateReimbursementDao.approveReimbursement(objectMapper.readValue(ReadRequest.getBody(req), Reimbursement.class));
        } catch (ErsException | IOException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean denyReimbursement(HttpServletRequest req) throws ErsException {
        try{
            return updateReimbursementDao.denyReimbursement(objectMapper.readValue(ReadRequest.getBody(req), Reimbursement.class));
        } catch (ErsException | IOException e) {
            log.error(e.getMessage(), e);
        }
        return false;
    }
}
