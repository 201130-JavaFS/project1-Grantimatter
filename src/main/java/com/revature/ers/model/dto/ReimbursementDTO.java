package com.revature.ers.model.dto;

import java.util.List;
import java.util.Objects;

public class ReimbursementDTO {
    public List<Integer> idList;
    public String newStatus;

    public ReimbursementDTO() {
    }

    public ReimbursementDTO(List<Integer> idList, String newStatus) {
        this.idList = idList;
        this.newStatus = newStatus;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementDTO that = (ReimbursementDTO) o;
        return Objects.equals(idList, that.idList) && Objects.equals(newStatus, that.newStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idList, newStatus);
    }

    @Override
    public String toString() {
        return "ReimbursementDTO{" +
                "idList=" + idList +
                ", newStatus='" + newStatus + '\'' +
                '}';
    }
}
