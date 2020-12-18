package com.revature.ers.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Role {

    int role_id;
    String role_name;
}
