package com.revature.ers.util.sorting;

import com.revature.ers.model.Reimbursement;

import java.util.Comparator;

public class SubmittedComparator implements Comparator<Reimbursement> {

    @Override
    public int compare(Reimbursement o1, Reimbursement o2) {
        //return o1.getSubmitted().compareTo(o2.getSubmitted());
        return o2.getSubmitted().compareTo(o1.getSubmitted());
    }
}
