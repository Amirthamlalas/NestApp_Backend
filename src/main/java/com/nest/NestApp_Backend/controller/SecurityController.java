package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.EmployeeDao;
import com.nest.NestApp_Backend.dao.LoginDao;
import com.nest.NestApp_Backend.dao.VisitorDao;
import com.nest.NestApp_Backend.model.EmployeeLog;
import com.nest.NestApp_Backend.model.Employees;
import com.nest.NestApp_Backend.model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private VisitorDao dao;

    @Autowired
    private LoginDao edao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/visitorlog",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> visitorlog(@RequestBody VisitorLog v){
        dao.save(v);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewvisitorlog")
    public List<VisitorLog> view(){
        return (List<VisitorLog>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeelog",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> employeelog(@RequestBody EmployeeLog e){
        edao.save(e);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;

    }

}
