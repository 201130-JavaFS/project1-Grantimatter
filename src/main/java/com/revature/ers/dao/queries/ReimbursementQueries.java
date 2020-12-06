package com.revature.ers.dao.queries;

public class ReimbursementQueries {
    // QUERIES
    public static final String GET_REIMBURSEMENT_DATA = "SELECT r.reimb_id, r.reimb_amount, r.reimb_author, r.reimb_type_id, r.reimb_status_id, r.reimb_submitted FROM \"ers\".\"ers_reimbursement\" AS r ";
    public static final String GET_REIMBURSEMENT_FROM_ID = GET_REIMBURSEMENT_DATA + "WHERE r.reimb_id=?;";
    public static final String GET_REIMBURSEMENT_FROM_AUTHOR_ID = GET_REIMBURSEMENT_DATA + "WHERE r.reimb_author=?;";

    // UPDATES
    public static final String CREATE_REIMBURSEMENT = "insert into \"ers\".\"ers_reimbursement\" (reimb_amount, reimb_author, reimb_type_id, reimb_status_id, reimb_submitted) values (?, ?, ?, 0, current_timestamp);";
}
