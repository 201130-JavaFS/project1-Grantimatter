package com.revature.ers.controllers;

import com.revature.ers.service.UserCreateService;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserCreateServiceImpl;
import com.revature.ers.service.impl.UserQueryServiceImpl;

public class UserController {
    UserQueryService userQueryService = new UserQueryServiceImpl();
    UserCreateService userCreateService = new UserCreateServiceImpl();

    public void getAllUsers(){

    }
}
