package com.revature.ers.dao.impl.util;

import com.revature.ers.model.Password;
import com.revature.ers.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PasswordUtil {

    static Logger log = LogManager.getLogger(PasswordUtil.class);

    public static Password getPasswordFromResultSet(ResultSet resultSet){
        Password password = null;
        if(resultSet != null) {
            try {
                password = new Password(
                        resultSet.getString("user_password_encrypted"),
                        resultSet.getString("password_salt")
                );
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        return password;
    }

    public static Password getNextPasswordFromResultSet(ResultSet resultSet){
        try {
            if(resultSet != null && resultSet.next()){
                return getPasswordFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public static List<Password> getPasswordsFromResultSet(ResultSet resultSet){
        List<Password> passwordList = new ArrayList<>();
        try {
            while (resultSet != null && resultSet.next()) {
                passwordList.add(getPasswordFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return passwordList;
    }
}
