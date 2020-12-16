package com.revature.ers.dao.impl;

import com.revature.ers.dao.PasswordQueryDao;
import com.revature.ers.dao.impl.util.PasswordUtil;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.queries.PasswordQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordQueryDaoImpl implements PasswordQueryDao {

    Logger log = LogManager.getLogger(PasswordQueryDaoImpl.class);

    @Override
    public Password getPasswordFromUserId(int id) throws ErsException {
        Password password = null;
        try{
            password = PasswordUtil.getNextPasswordFromResultSet(Queries.sendQuery(PasswordQueries.GET_PASSWORD_FROM_USER_ID, id));
        } catch (ErsException e) {
            e.printStackTrace();
        }
        return password;
    }

    @Override
    public boolean createNewPassword(Password password) throws ErsException {
        try{
            return Queries.sendUpdate(PasswordQueries.CREATE_NEW_PASSWORD, password.getUserId(), password.getEncrypted(), password.getSalt()) > 0;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        throw new ErsException("Unknown error, please contact SysAdmin");
    }
}
