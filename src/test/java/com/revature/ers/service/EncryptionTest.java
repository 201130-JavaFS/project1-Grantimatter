package com.revature.ers.service;

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
        log.info(String.format("Raw: %s\nEncrypted: %s\nGenerated Salt: %s", rawPassword, encrypted, salt));
    }

}