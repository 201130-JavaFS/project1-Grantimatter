package com.revature.ers.service;

import com.revature.ers.service.impl.util.Encryption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionTest {

    static Logger log = LogManager.getLogger(EncryptionTest.class);

    @Test
    void TestEncryption(){
        String salt = Encryption.getSalt(30);
        String givenSalt = "9x1tUlIoOkKJzyVxjin9XiBhTjYb8B";
        String rawPassword = "password";
        String encrypted = Encryption.generateSecurePassword(rawPassword, salt);
        assertNotEquals(rawPassword, encrypted);
    }
}