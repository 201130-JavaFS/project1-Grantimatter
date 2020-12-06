package com.revature.ers.model;

public class Password {
    private String encrypted;
    private String salt;

    public Password(String encrypted, String salt) {
        this.encrypted = encrypted;
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public boolean matchesPassword(String password){
        return (encrypted.equals(password));
    }
}
