package com.revature.ers.service.impl;

import com.revature.ers.dao.PasswordQueryDao;
import com.revature.ers.dao.impl.PasswordQueryDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;
import com.revature.ers.service.PasswordQueryService;
import org.apache.log4j.Logger;

public class PasswordQueryServiceImpl implements PasswordQueryService {

    Logger log = Logger.getLogger(PasswordQueryServiceImpl.class);
    PasswordQueryDao passwordQueryDao = new PasswordQueryDaoImpl();

    @Override
    public Password getPasswordFromUserId(int id) throws ErsException {
        Password password = null;
        try{
            password = passwordQueryDao.getPasswordFromUserId(id);
        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return password;
    }
}
