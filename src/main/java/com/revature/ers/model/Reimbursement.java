package com.revature.ers.model;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import java.sql.Timestamp;

public class Reimbursement {

    int id;
    double amount;
    int author_id;
    int resolver_id;
    int status_id;
    int type_id;
    String description;
    Timestamp submitted;
    Timestamp resolved;

    public Reimbursement(double amount, int author_id, int type_id) {
        this.amount = amount;
        this.author_id = author_id;
        this.type_id = type_id;
    }

    public Reimbursement(int id, double amount, int author_id, int type_id, int status_id, Timestamp submitted) {
        this(amount, author_id, type_id);
        this.id = id;
        this.status_id = status_id;
        this.submitted = submitted;
    }

    public Reimbursement(int id, double amount, int author_id, int resolver_id, int type_id, int status_id, String description, Timestamp submitted, Timestamp resolved) {
        this(id, amount, author_id, type_id, status_id, submitted);
        this.resolver_id = resolver_id;
        this.description = description;
        this.resolved = resolved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
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

    public int getType_id() {
        return type_id;
    }

    public void setType(int type_id) {
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\"=" + id +
                ", \"amount\"=" + amount +
                ", \"author_id\"=" + author_id +
                ", \"resolver_id\"=" + resolver_id +
                ", \"type_id\"=" + type_id +
                ", \"status\"=" + status_id +
                ", \"description\"=" + description +
                ", \"submitted\"=\"" + submitted +"\"" +
                ", \"resolved\"=" + resolved +
                "}";
    }
}
