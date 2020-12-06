package com.revature.ers.service.impl;

import com.revature.ers.dao.UserQueryDao;
import com.revature.ers.dao.impl.UserQueryDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import com.revature.ers.service.Encryption;
import com.revature.ers.service.PasswordQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.log4j.Logger;

public class UserQueryServiceImpl implements UserQueryService {

    Logger log = Logger.getLogger(UserQueryServiceImpl.class);
    UserQueryDao userQueryDao = new UserQueryDaoImpl();
    PasswordQueryService passwordQueryService = new PasswordQueryServiceImpl();

    @Override
    public User getUserFromLogin(String username_or_email, String given_password) {

        // Validate input Before this
        User user = null;
        try{
            // Get user from username or email and encrypt the password before sending the query
            user = userQueryDao.getUserFromLogin(username_or_email,
                    Encryption.generateSecurePassword(given_password,
                            passwordQueryService.getPasswordFromUserId(userQueryDao.getUserIdFromUsernameOrEmail(username_or_email)).getSalt()));
        } catch (ErsException e) {
            log.warn(e.getMessage());
        }
        return user;
    }
}
