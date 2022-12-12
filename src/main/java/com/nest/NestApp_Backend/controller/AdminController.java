package com.nest.NestApp_Backend.controller;


import com.nest.NestApp_Backend.dao.EmployeeDao;
import com.nest.NestApp_Backend.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class AdminController {
@Autowired
private EmployeeDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addEmployee(@RequestBody Employees e){
        dao.save(e);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<Employees>searchEmployee(@RequestBody Employees e){
        System.out.println(e.getName());
        return (List<Employees>)dao.searchEmployee(e.getName());
    }
}
