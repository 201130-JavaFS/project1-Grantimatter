package com.revature.ers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
public class Reimbursement {

    @Id
    int id;
    BigDecimal amount;
    String author;
    String resolver;
    String status;
    String type;
    String description;
    Date submitted;
    Date resolved;

    public Reimbursement(){

    }

    public Reimbursement(int id) {
        this.id = id;
    }

    public Reimbursement(BigDecimal amount, String author, String type) {
        this.amount = amount;
        this.author = author;
        this.type = type;
    }

    public Reimbursement(BigDecimal amount, String author, String type, String description) {
        this(amount, author, type);
        this.description = description;
    }

    public Reimbursement(int id, BigDecimal amount, String author, String type, String status, Timestamp submitted) {
        this(amount, author, type);
        this.id = id;
        this.status = status;
        this.submitted = submitted;
    }

    public Reimbursement(int id, BigDecimal amount, String author, String type, String description, String status, Timestamp submitted) {
        this(amount, author, type);
        this.id = id;
        this.status = status;
        this.description = description;
        this.submitted = submitted;
    }

    public Reimbursement(int id, BigDecimal amount, String author, String resolver, String type, String status, String description, Timestamp submitted, Timestamp resolved) {
        this(id, amount, author, type, description, status, submitted);
        this.resolver = resolver;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResolver() {
        return resolver;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return id == that.id && Objects.equals(amount, that.amount) && Objects.equals(author, that.author) && Objects.equals(resolver, that.resolver) && Objects.equals(status, that.status) && Objects.equals(type, that.type) && Objects.equals(description, that.description) && Objects.equals(submitted, that.submitted) && Objects.equals(resolved, that.resolved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, author, resolver, status, type, description, submitted, resolved);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "id=" + id +
                ", amount=" + amount +
                ", author='" + author + '\'' +
                ", resolver='" + resolver + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", submitted=" + submitted +
                ", resolved=" + resolved +
                '}';
    }
}
