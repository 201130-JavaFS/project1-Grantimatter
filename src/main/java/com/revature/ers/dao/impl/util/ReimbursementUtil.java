package com.revature.ers.dao.impl.util;

import com.revature.ers.model.Reimbursement;
import com.revature.ers.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementUtil {
    static Logger log = LogManager.getLogger(ReimbursementUtil.class);

    public static Reimbursement getReimbursementFromResultSet(ResultSet resultSet){
        Reimbursement reimbursement = null;
        if(resultSet != null){
            try{
                reimbursement = new Reimbursement(
                        resultSet.getInt("reimb_id"),
                        resultSet.getBigDecimal("reimb_amount"),
                        resultSet.getString("reimb_author"),
                        resultSet.getInt("reimb_author_id"),
                        resultSet.getString("reimb_resolver"),
                        resultSet.getString("reimb_type"),
                        resultSet.getString("reimb_status"),
                        resultSet.getString("reimb_description"),
                        resultSet.getTimestamp("reimb_submitted"),
                        resultSet.getTimestamp("reimb_resolved")
                );
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        return reimbursement;
    }

    public static Reimbursement getNextReimbursementFromResultSet(ResultSet resultSet){
        if(resultSet != null) {
            try {
                if (resultSet.next()) {
                    return getReimbursementFromResultSet(resultSet);
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public static List<Reimbursement> getReimbursementsFromResultSet(ResultSet resultSet){
        List<Reimbursement> reimbursementList = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    reimbursementList.add(getReimbursementFromResultSet(resultSet));
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
        return reimbursementList;
    }
}
