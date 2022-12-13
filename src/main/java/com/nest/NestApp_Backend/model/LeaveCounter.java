package com.nest.NestApp_Backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "counter")
public class LeaveCounter {

    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private int sickleave=20;
    private int casualleave=7;
    private int specialleave=3;
    private int Total=30;

    public LeaveCounter() {
    }

    public LeaveCounter(int id, int empid, int sickleave, int casualleave, int specialleave, int total) {
        this.id = id;
        this.empid = empid;
        this.sickleave = sickleave;
        this.casualleave = casualleave;
        this.specialleave = specialleave;
        Total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getSickleave() {
        return sickleave;
    }

    public void setSickleave(int sickleave) {
        this.sickleave = sickleave;
    }

    public int getCasualleave() {
        return casualleave;
    }

    public void setCasualleave(int casualleave) {
        this.casualleave = casualleave;
    }

    public int getSpecialleave() {
        return specialleave;
    }

    public void setSpecialleave(int specialleave) {
        this.specialleave = specialleave;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }
}
