package com.revature.ers.dao.impl;

import com.revature.ers.dao.UserQueryDao;
import com.revature.ers.dao.impl.util.Queries;
import com.revature.ers.dao.impl.util.UserUtil;
import com.revature.ers.dao.queries.UserQueries;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserQueryDaoImpl implements UserQueryDao {
    Logger log = Logger.getLogger(UserQueryDaoImpl.class);

    @Override
    public User getUserFromLogin(String username_or_email, String given_password) {
        User user = null;
        try{
            user = UserUtil.getNextUserFromResultSet(Queries.sendQuery(UserQueries.GET_USER_FROM_LOGIN, username_or_email, username_or_email, given_password));
        } catch (ErsException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    @Override
    public int getUserIdFromUsernameOrEmail(String username_or_email) throws ErsException {
        int id = 0;
        try{
            ResultSet resultSet = Queries.sendQuery(UserQueries.GET_USER_ID_FROM_USERNAME_OR_EMAIL, username_or_email, username_or_email);
            if(resultSet != null && resultSet.next()){
                id = resultSet.getInt("ers_users_id");
            }
        } catch (ErsException | SQLException e) {
            log.error(e.getMessage(), e);
        }
        return id;
    }
}
