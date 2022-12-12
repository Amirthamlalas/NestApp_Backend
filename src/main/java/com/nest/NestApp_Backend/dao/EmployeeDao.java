package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.Employees;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {
}
