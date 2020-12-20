package com.revature.ers.service.impl;

import com.revature.ers.model.User;
import com.revature.ers.service.UserQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

class UserQueryServiceImplTest {
    Logger log = LogManager.getLogger(UserQueryServiceImplTest.class);
    UserQueryService userQueryService = new UserQueryServiceImpl();
/*
    @Test
    void testGetUserFromLogin() {
        User grant = userQueryService.getUserFromLogin("grant.wiswell", "password");
        if(grant != null) log.info("User Grant: " + grant);
    }

 */
}