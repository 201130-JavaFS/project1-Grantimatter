package com.revature.ers.model.dto;

import java.util.Objects;

public class UserDTO {
    public String full_name;
    public int role_id;
    public int id;

    public UserDTO() {
        super();
    }

    public UserDTO(String full_name, int role_id) {
        this();
        this.full_name = full_name;
        this.role_id = role_id;
    }

    public UserDTO(String full_name, int role_id, int id) {
        this(full_name, role_id);
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return role_id == userDTO.role_id && id == userDTO.id && Objects.equals(full_name, userDTO.full_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(full_name, role_id, id);
    }
}
