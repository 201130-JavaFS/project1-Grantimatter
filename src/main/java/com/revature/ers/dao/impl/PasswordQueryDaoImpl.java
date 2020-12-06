package com.revature.ers.dao.impl;

import com.revature.ers.dao.PasswordQueryDao;
import com.revature.ers.dao.impl.util.PasswordUtil;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.queries.PasswordQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;
import org.apache.log4j.Logger;

public class PasswordQueryDaoImpl implements PasswordQueryDao {

    Logger log = Logger.getLogger(PasswordQueryDaoImpl.class);

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
}
