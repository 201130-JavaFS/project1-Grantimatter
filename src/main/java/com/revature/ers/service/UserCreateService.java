package com.revature.ers.service;

import com.revature.ers.exception.ErsException;
import com.revature.ers.model.User;

import javax.servlet.http.HttpServletRequest;

public interface UserCreateService {
    public boolean createNewUser(HttpServletRequest req) throws ErsException;
}
