package com.revature.ers.dao.impl.util;

import com.revature.ers.model.User;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {
    static Logger log = Logger.getLogger(UserUtil.class);

    public static User getUserFromResultSet(ResultSet resultSet){
        User user = null;
        try{
            user = new User(
                    resultSet.getInt("ers_users_id"),
                    resultSet.getInt("user_role_id"),
                    resultSet.getString("ers_username"),
                    resultSet.getString("user_first_name"),
                    resultSet.getString("user_last_name"),
                    resultSet.getString("user_email")
            );
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return user;
    }

    public static User getNextUserFromResultSet(ResultSet resultSet){
        try {
            if(resultSet.next()){
                return getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static List<User> getUsersFromResultSet(ResultSet resultSet){
        List<User> userList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                userList.add(getUserFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return userList;
    }
}
