package com.revature.ers.dao.queries;

public class PasswordQueries {
    // QUERIES
    public static final String GET_PASSWORD_FROM_USER_ID = "SELECT user_password_encrypted, password_salt FROM ers_user_passwords WHERE ers_users_id=?";

    // UPDATES
    public static final String CREATE_NEW_PASSWORD = "INSERT INTO ers_passwords (ers_users_id, user_password_encrypted, password_salt) VALUES (?,?,?)";
}
