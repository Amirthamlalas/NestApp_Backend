package com.nest.NestApp_Backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitor")
public class VisitorLog {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String purpose;
    private String whom_to_meet;
    private String entry_time;
    private String exit_time;

    public VisitorLog() {
    }

    public VisitorLog(int id, String name, String purpose, String whom_to_meet, String entry_time, String exit_time) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.whom_to_meet = whom_to_meet;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWhom_to_meet() {
        return whom_to_meet;
    }

    public void setWhom_to_meet(String whom_to_meet) {
        this.whom_to_meet = whom_to_meet;
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
