package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Password;

public interface PasswordQueryService {
    public Password getPasswordFromUserId(int id) throws ErsException;
}
