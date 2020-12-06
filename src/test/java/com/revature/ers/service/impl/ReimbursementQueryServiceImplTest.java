package com.revature.ers.service.impl;

import com.revature.ers.dao.impl.util.ReimbursementUtil;
import com.revature.ers.exception.ErsException;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import com.revature.ers.service.ReimbursementQueryService;
import com.revature.ers.service.UserQueryService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementQueryServiceImplTest {
    Logger log = Logger.getLogger(ReimbursementQueryServiceImplTest.class);

    UserQueryService userQueryService = new UserQueryServiceImpl();
    ReimbursementQueryService reimbursementQueryService = new ReimbursementQueryServiceImpl();

    @Test
    void testGetReimbursementsFromAuthor() {
        List<Reimbursement> reimbursementList = new ArrayList<>();
        try{
            User grant = userQueryService.getUserFromLogin("grant.wiswell","password");
            reimbursementList = reimbursementQueryService.getReimbursementsFromAuthor(grant.getId());
        } catch (ErsException e) {
            log.error(e.getMessage(), e);
        }
        assert(reimbursementList.size() > 0);

        for (Reimbursement r:reimbursementList) {
            log.info(r);
        }
    }
}