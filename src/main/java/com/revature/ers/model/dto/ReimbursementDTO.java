package com.revature.ers.model.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ReimbursementDTO {

    public BigDecimal amount;
    public int type_id;
    public String description;

    public List<Integer> idList;
    public String newStatus;

    public ReimbursementDTO() {
    }

    public ReimbursementDTO(List<Integer> idList, String newStatus) {
        this.idList = idList;
        this.newStatus = newStatus;
    }

    public ReimbursementDTO(BigDecimal amount, int type_id, String description) {
        this.amount = amount;
        this.type_id = type_id;
        this.description = description;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementDTO that = (ReimbursementDTO) o;
        return Objects.equals(amount, that.amount) && Objects.equals(type_id, that.type_id) && Objects.equals(description, that.description) && Objects.equals(idList, that.idList) && Objects.equals(newStatus, that.newStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, type_id, description, idList, newStatus);
    }

    @Override
    public String toString() {
        return "ReimbursementDTO{" +
                "amount=" + amount +
                ", type='" + type_id + '\'' +
                ", descripition='" + description + '\'' +
                ", idList=" + idList +
                ", newStatus='" + newStatus + '\'' +
                '}';
    }
}
