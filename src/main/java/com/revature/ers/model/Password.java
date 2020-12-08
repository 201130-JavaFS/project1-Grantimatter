package com.revature.ers.model;

public class Password {
    int userId;
    private String encrypted;
    private String salt;

    public Password(String encrypted, String salt) {
        this.encrypted = encrypted;
        this.salt = salt;
    }

    public Password(int userId, String encrypted, String salt) {
        this(encrypted, salt);
        this.userId = userId;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public int getUserId() {
        return userId;
    }

    public String getSalt() {
        return salt;
    }
}
