package com.revature.ers.service.impl;

import com.revature.ers.model.Password;
import com.revature.ers.service.PasswordQueryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordQueryServiceImplTest {

    static Logger log = LogManager.getLogger(PasswordQueryServiceImplTest.class);
    PasswordQueryService passwordQueryService = new PasswordQueryServiceImpl();

    @Test
    void getPasswordFromUserId() {
        Password password = passwordQueryService.getPasswordFromUserId(1);
        assertNotNull(password);
    }
}