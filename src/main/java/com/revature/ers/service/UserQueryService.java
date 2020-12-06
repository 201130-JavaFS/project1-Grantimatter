package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;

public interface UserQueryService {
    public User getUserFromLogin(String username_or_email, String given_password) throws ErsException;
}
