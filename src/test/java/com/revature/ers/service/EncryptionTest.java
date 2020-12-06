package com.revature.ers.service;

import com.revature.ers.service.impl.util.Encryption;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

class EncryptionTest {

    Logger log = Logger.getLogger(EncryptionTest.class);

    @Test
    void TestEncryption(){
        String salt = Encryption.getSalt(30);
        String givenSalt = "9x1tUlIoOkKJzyVxjin9XiBhTjYb8B";
        String rawPassword = "password";
        String encrypted = Encryption.generateSecurePassword(rawPassword, givenSalt);
        log.info(String.format("Raw: %s", rawPassword));
        log.info(String.format("Encrypted: %s", encrypted));
        log.info(String.format("Generated Salt: %s", salt));
    }

}