package com.revature.ers.dao;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;

public interface PasswordQueryDao {
    public Password getPasswordFromUserId(int id) throws ErsException;
}
