package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.LeaveCounterDao;
import com.nest.NestApp_Backend.dao.LeaveDao;
import com.nest.NestApp_Backend.model.Employees;
import com.nest.NestApp_Backend.model.LeaveApplication;
import com.nest.NestApp_Backend.model.LeaveCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {

    Date currentdate=new Date();
    @Autowired
    private LeaveDao dao;

    @Autowired
    private LeaveCounterDao ldao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/applyleave",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> applyLeave(@RequestBody LeaveApplication l){
        l.setApply_date(String.valueOf(currentdate));
        l.setStatus(0);

        dao.save(l);
        List<LeaveApplication>result=(List<LeaveApplication>)dao.id(l.getEmpid());
        HashMap<String,String>map=new HashMap<>();
        if(result.size()==0){
            map.put("status","failed");
        }else {
            int id = result.get(0).getId();
            map.put("id",String.valueOf(id));
            map.put("status","success");

        }
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
        dao.updateStatus(l.getEmpid(),l.getStatus(),l.getId());
        HashMap< String,String> map=new HashMap<>();

            map.put("status","success");


        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/updatecounter",consumes = "application/json",produces = "application/json")
    public Map<String,String> Updatecounter(@RequestBody LeaveApplication l) throws ParseException {

        String empid=String.valueOf(l.getEmpid());

        List<LeaveApplication> result1 = (List<LeaveApplication>) dao.counterStatus(l.getEmpid());
        l.setLeavetype(result1.get(0).getLeavetype());

        LocalDate from_date = LocalDate.parse(result1.get(0).getFrom_data());
        LocalDate to_date = LocalDate.parse(result1.get(0).getTo_date());

        long daysDiff = ChronoUnit.DAYS.between(from_date,to_date)+1;
        System.out.println("The number of days between dates: " + daysDiff);


        List<LeaveCounter> result= (List<LeaveCounter>) ldao.Leaves(l.getEmpid());
        long casual=result.get(0).getCasualleave();
        long sick=result.get(0).getSickleave();
        long special=result.get(0).getSpecialleave();


        long total=30;



        if (l.getLeavetype().equalsIgnoreCase("casual") && daysDiff<=casual){
            casual=casual-daysDiff;
            sick=sick;
            special=special;
            total=casual+sick+special;

            ldao.updateCounter(l.getEmpid(), (int) total, (int) casual, (int) sick, (int) special);


        } else if (l.getLeavetype().equalsIgnoreCase("sick") && daysDiff<=sick) {
            casual=casual;
            sick=sick-daysDiff;
            special=special;
            total=casual+sick+special;
            ldao.updateCounter(l.getEmpid(), (int) total, (int) casual, (int) sick, (int) special);
        }else if(l.getLeavetype().equalsIgnoreCase("special") && daysDiff<=special) {
            casual=casual;
            sick=sick;
            special=special-daysDiff;
            total=casual+sick+special;
            ldao.updateCounter(l.getEmpid(), (int) total, (int) casual, (int) sick, (int) special);
        }else{
            HashMap<String,String> map=new HashMap<>();
            map.put("leavetype", l.getLeavetype());
            String id=String.valueOf(result.get(0).getEmpid());
            map.put("empid", id);
            map.put("message", "no leaves");
            return map;
        }
        HashMap< String,String> map=new HashMap<>();
        List<LeaveCounter> result3= (List<LeaveCounter>) ldao.Leaves(l.getEmpid());
        int val=result3.get(0).getTotal();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchstatus",consumes = "application/json",produces = "application/json")
    public List<LeaveApplication>searchstatus(@RequestBody LeaveApplication l){
        System.out.println(l.getId());
        return (List<LeaveApplication>)dao.searchStatus(l.getId());
    }




}
