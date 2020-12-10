package com.revature.ers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestObjectMapper {

    Logger log = Logger.getLogger(TestObjectMapper.class);

    @Test
    void testMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User(0,0,"grantimater","grant","wiswell","gt101boy@gmail.com");
        Reimbursement reimbursement = new Reimbursement(new BigDecimal(19.29),0,2, "A description!");
        try {
            String userJson = "{\"id\":0,\"role_id\":0,\"username\":\"grantimater\",\"first_name\":\"grant\",\"last_name\":\"wiswell\",\"email\":\"gt101boy@gmail.com\",\"reimbursementList\":null}";
            String reimbJson = "{\"amount\":100.23,\"author_id\":0,\"type_id\":2,\"description\":\"A description!\"}";
            //log.info(objectMapper.readValue(userJson, User.class));
            //log.info(objectMapper.writeValueAsString(user));

            //log.info(objectMapper.writeValueAsString(reimbursement));
            log.info(objectMapper.readValue(reimbJson, Reimbursement.class));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
