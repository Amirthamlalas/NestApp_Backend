package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.LeaveApplication;
import org.springframework.data.repository.CrudRepository;

public interface LeaveDao extends CrudRepository<LeaveApplication,Integer> {
}
