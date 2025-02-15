package com.revature.ers.model;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
public class User {

    private int id;
    private int role_id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private List<Reimbursement> reimbursementList;

    public User(){ }

    public User(int role_id, String username, String first_name, String last_name, String email) {
        super();
        this.role_id = role_id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public User(int id, int role_id, String username, String first_name, String last_name, String email) {
        this(role_id, username, first_name, last_name, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reimbursement> getReimbursementList() {
        return reimbursementList;
    }

    public void setReimbursementList(List<Reimbursement> reimbursementList) {
        this.reimbursementList = reimbursementList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && role_id == user.role_id && username.equals(user.username) && first_name.equals(user.first_name) && last_name.equals(user.last_name) && email.equals(user.email) && Objects.equals(reimbursementList, user.reimbursementList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_id, username, first_name, last_name, email, reimbursementList);
    }

    @Override
    public String toString() {
        return  first_name+"{"+
                "id=" + id +
                ", role_id=" + role_id +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", reimbursementList=" + reimbursementList +
                '}';
    }
}
