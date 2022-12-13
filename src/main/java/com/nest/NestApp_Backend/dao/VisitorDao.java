package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.controller.SecurityController;
import com.nest.NestApp_Backend.model.VisitorLog;
import org.springframework.data.repository.CrudRepository;

public interface VisitorDao extends CrudRepository<VisitorLog,Integer> {
}
