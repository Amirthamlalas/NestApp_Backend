package com.nest.NestApp_Backend.controller;


import com.nest.NestApp_Backend.dao.EmployeeDao;
import com.nest.NestApp_Backend.dao.LeaveCounterDao;
import com.nest.NestApp_Backend.dao.LeaveDao;
import com.nest.NestApp_Backend.dao.SecurityDao;
import com.nest.NestApp_Backend.model.Employees;
import com.nest.NestApp_Backend.model.LeaveApplication;
import com.nest.NestApp_Backend.model.LeaveCounter;
import com.nest.NestApp_Backend.model.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.HashMap;
import java.util.List;

@RestController
public class AdminController {
@Autowired
private EmployeeDao dao;

@Autowired
private SecurityDao sdao;

@Autowired
private LeaveCounterDao ldao;

int year= Year.now().getValue();
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addEmployee(@RequestBody Employees e){
        dao.save(e);
        HashMap<String,String>map=new HashMap<>();
        map.put("empid",String.valueOf(e.getId()));
        LeaveCounter l = new LeaveCounter();
        l.setEmpid(e.getId());
        l.setCasualleave(20);
        l.setSickleave(7);
        l.setSpecialleave(3);
        l.setYear(String.valueOf(year));
        ldao.save(l);
        map.put("status","success");
        return map;
    }



    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> addSecurity(@RequestBody SecurityGuard s){
        sdao.save(s);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json",produces = "application/json")
    public List<Employees>searchEmployee(@RequestBody Employees e){
        System.out.println(e.getEmpid());
        return (List<Employees>)dao.searchEmployee(e.getEmpid());
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
    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @PostMapping(path = "viewprofile",produces = "application/json",consumes = "application/json")
    public List<Employees>viewProfile(@RequestBody Employees e){
        String id= String.valueOf(e.getId());
        System.out.println(id);
        return (List<Employees>)dao.ViewProfile(e.getId());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securitylogin",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> securityLogin(@RequestBody SecurityGuard s){
        List<SecurityGuard> result = (List<SecurityGuard>) sdao.login(s.getUsername(),s.getPassword());
        HashMap<String,String>map=new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
        }else {

            map.put("status","success");
        }

        return map;
    }
}
