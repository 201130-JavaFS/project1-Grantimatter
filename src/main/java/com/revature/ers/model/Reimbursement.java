package com.revature.ers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reimbursement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    BigDecimal amount;
    @Column(nullable = false)
    int author_id;
    int resolver_id;
    @Column(nullable = false)
    int status_id;
    @Column(nullable = false)
    int type_id;
    String description;
    Date submitted;
    Date resolved;

    public Reimbursement(){

    }

    public Reimbursement(BigDecimal amount, int author_id, int type_id) {
        this.amount = amount;
        this.author_id = author_id;
        this.type_id = type_id;
    }

    public Reimbursement(BigDecimal amount, int author_id, int type_id, String description) {
        this(amount, author_id, type_id);
        this.description = description;
    }

    public Reimbursement(int id, BigDecimal amount, int author_id, int type_id, int status_id, Timestamp submitted) {
        this(amount, author_id, type_id);
        this.id = id;
        this.status_id = status_id;
        this.submitted = submitted;
    }

    public Reimbursement(int id, BigDecimal amount, int author_id, int type_id, String description, int status_id, Timestamp submitted) {
        this(amount, author_id, type_id);
        this.id = id;
        this.status_id = status_id;
        this.description = description;
        this.submitted = submitted;
    }

    public Reimbursement(int id, BigDecimal amount, int author_id, int resolver_id, int type_id, int status_id, String description, Timestamp submitted, Timestamp resolved) {
        this(id, amount, author_id, type_id, description, status_id, submitted);
        this.resolver_id = resolver_id;
        this.resolved = resolved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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

    public Date getSubmitted() {
        return submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public Date getResolved() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && author_id == that.author_id && resolver_id == that.resolver_id && status_id == that.status_id && type_id == that.type_id && Objects.equals(amount, that.amount) && Objects.equals(description, that.description) && Objects.equals(submitted, that.submitted) && Objects.equals(resolved, that.resolved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, author_id, resolver_id, status_id, type_id, description, submitted, resolved);
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
