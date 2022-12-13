package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.LeaveDao;
import com.nest.NestApp_Backend.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewallleave")
    public List<Map<String,String>>viewallLeave(){
        return(List<Map<String,String>>)dao.viewLeave();


    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public Map<String,String> UpdateStatus(@RequestBody LeaveApplication l)
    {
        String empid=String.valueOf(l.getEmpid());
        String status=l.getStatus().toString();
        System.out.println(empid);
        System.out.println(status);
        List<LeaveApplication> result=dao.updateStatus(l.getEmpid(),l.getStatus());
        HashMap< String,String> map=new HashMap<>();
        if(result.size()==0)
        {
            map.put("status","failed");
        }
        else {
            String leavetype=result.get(0).getLeavetype();
            map.put("leaveType",String.valueOf(leavetype));
            map.put("status","success");
        }

        return map;
    }




}
