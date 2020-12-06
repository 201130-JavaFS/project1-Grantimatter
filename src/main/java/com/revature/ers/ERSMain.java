package com.revature.ers;

import com.revature.ers.service.Encryption;
import com.revature.ers.service.UserQueryService;
import com.revature.ers.service.impl.UserQueryServiceImpl;
import org.apache.log4j.Logger;

public class ERSMain {
    static Logger log = Logger.getLogger(ERSMain.class);

    public static void main(String[] args) {
        UserQueryService userQueryService = new UserQueryServiceImpl();

    }
}
