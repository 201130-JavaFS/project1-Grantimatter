package com.revature.ers.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestService {
    static Logger log = LogManager.getLogger(TestService.class);

    @Test
    public void runThis(){
        log.info("I'm working!");
    }
}
