package com.revature.ers.service.impl;

import com.revature.ers.dao.UserQueryDao;
import com.revature.ers.dao.impl.UserQueryDaoImpl;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;
import com.revature.ers.model.User;
import com.revature.ers.service.impl.util.Encryption;
import com.revature.ers.service.PasswordQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

public class UserQueryServiceImpl implements UserQueryService {

    Logger log = LogManager.getLogger(UserQueryServiceImpl.class);
    UserQueryDao userQueryDao = new UserQueryDaoImpl();
    PasswordQueryService passwordQueryService = new PasswordQueryServiceImpl();

    @Override
    public User getUserFromLogin(String username_or_email, String given_password) {

        // Validate input Before this
        User user = null;
        try{
            // Get user from username or email and encrypt the password before sending the query
            int id = userQueryDao.getUserIdFromUsernameOrEmail(username_or_email);
            if(id > -1){
                Password password = passwordQueryService.getPasswordFromUserId(id);
                if(password != null){
                    user = userQueryDao.getUserFromLogin(username_or_email, Encryption.generateSecurePassword(given_password, password.getSalt()));
                }

            }
        } catch (ErsException e) {
            log.warn(e.getMessage());
        }
        return user;
    }
}
