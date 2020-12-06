package com.revature.ers.model;

import java.sql.Timestamp;

public class Reimbursement {
    int id;
    int amount;
    int author_id;
    int resolver_id;
    int type_id;
    int status_id;
    String description;
    Timestamp submitted;
    Timestamp resolved;

    public Reimbursement(int id, int amount, int author_id, int resolver_id, int type_id, int status_id, String description, Timestamp submitted, Timestamp resolved) {
        this.id = id;
        this.amount = amount;
        this.author_id = author_id;
        this.resolver_id = resolver_id;
        this.type_id = type_id;
        this.status_id = status_id;
        this.description = description;
        this.submitted = submitted;
        this.resolved = resolved;
    }

    public Reimbursement(int id, int amount, int author_id, int type_id, int status_id, Timestamp submitted) {
        this.id = id;
        this.amount = amount;
        this.author_id = author_id;
        this.type_id = type_id;
        this.status_id = status_id;
        this.submitted = submitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getResolver_id() {
        return resolver_id;
    }

    public void setResolver_id(int resolver_id) {
        this.resolver_id = resolver_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Timestamp getResolved() {
        return resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }
}
