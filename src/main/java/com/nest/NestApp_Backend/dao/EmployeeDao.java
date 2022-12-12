package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empid`, `name`, `password`, `phoneno`, `salary`, `username` FROM `employees` WHERE `name`= :name",nativeQuery = true)
    List<Employees>searchEmployee(@Param("name")String name);
}
