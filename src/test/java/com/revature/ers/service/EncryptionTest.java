package com.revature.ers.service;

import com.revature.ers.service.impl.util.Encryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

class EncryptionTest {

    Logger log = LogManager.getLogger(EncryptionTest.class);

    @Test
    void TestEncryption(){
        String salt = Encryption.getSalt(30);
        String givenSalt = "9x1tUlIoOkKJzyVxjin9XiBhTjYb8B";
        String rawPassword = "password";
        String encrypted = Encryption.generateSecurePassword(rawPassword, salt);
        log.info(String.format("Raw: %s", rawPassword));
        log.info(String.format("Encrypted: %s", encrypted));
        log.info(String.format("Generated Salt: %s", salt));
    }

}