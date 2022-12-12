package com.nest.NestApp_Backend.controller;


import com.nest.NestApp_Backend.dao.EmployeeDao;
import com.nest.NestApp_Backend.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String>delete(@RequestBody Employees e){
        String id = String.valueOf(e.getId());
        dao.deleteEmployee(e.getId());
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin("*")
    @GetMapping("/viewemployee")
    public List<Employees>view(){
        return (List<Employees>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String>update(@RequestBody Employees e){
        String id = String.valueOf(e.getId());

        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeelogin",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> login(@RequestBody Employees e){
        List<Employees> result = (List<Employees>) dao.login(e.getUsername(),e.getPassword());
        HashMap<String,String>map=new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
        }else {
            int id = result.get(0).getId();
            map.put("employeeid",String.valueOf(id));
            map.put("status","success");
        }

        return map;
    }
}
