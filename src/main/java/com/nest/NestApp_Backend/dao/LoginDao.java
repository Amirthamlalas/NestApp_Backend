package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.EmployeeLog;
import org.springframework.data.repository.CrudRepository;

public interface LoginDao extends CrudRepository<EmployeeLog,Integer> {
}
