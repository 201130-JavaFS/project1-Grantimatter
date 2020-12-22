package com.revature.ers.dao.queries;

public class ReimbursementQueries {
    // QUERIES
    //public static final String GET_REIMBURSEMENT_DATA = "SELECT r.reimb_id, r.reimb_amount, r.reimb_author, r.reimb_type_id, r.reimb_description, r.reimb_status_id, r.reimb_submitted, r.reimb_resolved, r.reimb_resolver FROM ers_reimbursement AS r ";
    public static final String GET_REIMBURSEMENT_DATA =
            "SELECT r.reimb_id, r.reimb_amount, ua.user_email AS reimb_author , rt.reimb_type, r.reimb_description, rs.reimb_status, r.reimb_submitted, r.reimb_resolved, ur.user_email AS reimb_resolver " +
                    "FROM ers_reimbursement AS r " +
                    "LEFT JOIN ers_reimbursement_status AS rs ON r.reimb_status_id = rs.reimb_status_id " +
                    "LEFT JOIN ers_reimbursement_type AS rt ON r.reimb_type_id = rt.reimb_type_id " +
                    "LEFT JOIN ers_users AS ua ON r.reimb_author = ua.ers_users_id " +
                    "LEFT JOIN ers_users AS ur ON r.reimb_resolver = ur.ers_users_id ";
    public static final String GET_REIMBURSEMENT_FROM_ID = GET_REIMBURSEMENT_DATA + "WHERE r.reimb_id=?;";
    public static final String GET_REIMBURSEMENT_FROM_AUTHOR_ID = GET_REIMBURSEMENT_DATA + "WHERE r.reimb_author=?;";
    public static final String GET_REIMBURSEMENT_FROM_STATUS_ID = GET_REIMBURSEMENT_DATA + "WHERE r.reimb_status_id=?";
    public static final String GET_ALL_REIMBURSEMENTS = GET_REIMBURSEMENT_DATA;

    // UPDATES
    public static final String CREATE_REIMBURSEMENT = "INSERT INTO ers_reimbursement (reimb_amount, reimb_author, reimb_type_id, reimb_description) VALUES (?,?,?,?);";
    public static final String CREATE_REIMBURSEMENT_MIN = "INSERT INTO ers_reimbursement (reimb_amount, reimb_author, reimb_type_id) VALUES (?,?,?);";
    public static final String APPROVE_REIMBURSEMENT = "UPDATE ers_reimbursement SET reimb_status_id=1, reimb_resolver=?, reimb_resolved=current_timestamp WHERE reimb_id=?";
    public static final String DENY_REIMBURSEMENT = "UPDATE ers_reimbursement SET reimb_status_id=2, reimb_resolver=?, reimb_resolved=current_timestamp WHERE reimb_id=?";
}
