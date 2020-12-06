package com.revature.ers.dao;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;

public interface UserQueryDao {
    public User getUserFromLogin(String username_or_email, String given_password) throws ErsException;
    public int getUserIdFromUsernameOrEmail(String username_or_email) throws ErsException;
}
