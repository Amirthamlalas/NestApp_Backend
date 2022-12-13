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
    private int sickleave;
    private int casualleave;
    private int specialleave;
    private String year;

    private int total=30;

    public LeaveCounter() {
    }

    public LeaveCounter(int id, int empid, int sickleave, int casualleave, int specialleave,  String year,int total) {
        this.id = id;
        this.empid = empid;
        this.sickleave = sickleave;
        this.casualleave = casualleave;
        this.specialleave = specialleave;
        this.year = year;
        this.total =total;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
