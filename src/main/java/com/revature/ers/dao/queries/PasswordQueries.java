package com.revature.ers.dao.queries;

public class PasswordQueries {
    public static final String GET_PASSWORD_FROM_USER_ID = "SELECT user_password_encrypted, password_salt FROM ers.ers_user_passwords WHERE ers_users_id=?";
}
