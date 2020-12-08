package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;

public interface UserCreateService {
    public boolean createNewUser(User user) throws ErsException;
}
