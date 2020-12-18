package com.revature.ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Password {

    @Id
    int userId;
    private String encrypted;
    private String salt;

    public Password(){

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return userId == password.userId && Objects.equals(encrypted, password.encrypted) && Objects.equals(salt, password.salt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, encrypted, salt);
    }
}
