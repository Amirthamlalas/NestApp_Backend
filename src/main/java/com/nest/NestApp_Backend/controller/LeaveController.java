package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.LeaveDao;
import com.nest.NestApp_Backend.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LeaveController {
    @Autowired
    private LeaveDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> applyLeave(@RequestBody LeaveApplication l){
        dao.save(l);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
