package com.revature.ers.service.impl;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import com.revature.ers.service.UserCreateService;
import org.apache.log4j.Logger;

public class UserCreateServiceImpl implements UserCreateService {

    Logger log = Logger.getLogger(UserCreateServiceImpl.class);

    @Override
    public boolean createNewUser(User user) throws ErsException {
        try{

        } catch (ErsException e) {
            log.warn(e.getMessage(), e);
        }
        return false;
    }
}
