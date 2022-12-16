package com.nest.NestApp_Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeelogin")
public class EmployeeLog {

    @Id
    @GeneratedValue
    private int id;
    private int empid;
    private String date;
    private String entry_time;
    private String exit_time;

    public EmployeeLog() {
    }

    public EmployeeLog(int id, int empid, String date, String entry_time, String exit_time) {
        this.id = id;
        this.empid = empid;
        this.date = date;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getExit_time() {
        return exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }
}
