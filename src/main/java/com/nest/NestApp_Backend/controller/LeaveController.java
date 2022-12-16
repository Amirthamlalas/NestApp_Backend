package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.LeaveDao;
import com.nest.NestApp_Backend.model.Employees;
import com.nest.NestApp_Backend.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    Date currentdate=new Date();
    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> applyLeave(@RequestBody LeaveApplication l){
        l.setApply_date(String.valueOf(currentdate));
        dao.save(l);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewallleave")
    public List<LeaveApplication>viewLeave(){
        return(List<LeaveApplication>)dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody LeaveApplication l)
    {
        String empid=String.valueOf(l.getEmpid());
        String status=String.valueOf(l.getStatus());
        System.out.println(empid);
        System.out.println(status);
        dao.updateStatus(l.getEmpid(),l.getStatus());
        HashMap< String,String> map=new HashMap<>();

            map.put("status","success");


        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchstatus",consumes = "application/json",produces = "application/json")
    public List<LeaveApplication>searchstatus(@RequestBody LeaveApplication l){
        System.out.println(l.getEmpid());
        return (List<LeaveApplication>)dao.searchStatus(l.getEmpid());
    }




}
