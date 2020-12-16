package com.revature.ers.dao.queries;

public class UserQueries {
    // QUERIES
    public static final String GET_USER_ID_FROM_USERNAME_OR_EMAIL = "SELECT ers_users_id FROM ers_users WHERE ers_username ILIKE ? OR user_email ILIKE ?";
    public static final String GET_USER_DATA = "SELECT ers_users_id, user_role_id, ers_username, user_first_name, user_last_name, user_email FROM ers_users ";
    public static final String GET_USER_FROM_LOGIN = "SELECT ers_users.ers_users_id, ers_users.user_role_id, ers_users.ers_username, ers_users.user_first_name, ers_users.user_last_name, ers_users.user_email FROM ers_users JOIN ers_user_passwords ON ers_users.ers_users_id = ers_user_passwords.ers_users_id WHERE (ers_users.user_email ILIKE ? OR ers_users.ers_username ILIKE ?) AND user_password_encrypted=?;";

    // UPDATES
    public static final String CREATE_NEW_USER = "insert into ers_users (user_role_id, ers_username, user_first_name, user_last_name, user_email) values (?,?,?,?,?)";
}
