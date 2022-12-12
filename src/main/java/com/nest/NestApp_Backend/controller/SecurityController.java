package com.nest.NestApp_Backend.controller;

import com.nest.NestApp_Backend.dao.VisitorDao;
import com.nest.NestApp_Backend.model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SecurityController {
    @Autowired
    private VisitorDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/visitorlog",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> visitorlog(@RequestBody VisitorLog v){
        dao.save(v);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;

    }

}
