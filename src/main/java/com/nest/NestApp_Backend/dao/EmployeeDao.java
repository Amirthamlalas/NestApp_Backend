package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.Employees;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employees,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `empid`, `name`, `password`, `phoneno`, `salary`, `username` FROM `employees` WHERE `name`= :name",nativeQuery = true)
    List<Employees>searchEmployee(@Param("name")String name);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `employees` WHERE `id`= :id",nativeQuery = true)
    void deleteEmployee(@Param("id")Integer id);

    @Query(value = "SELECT * FROM `employees` WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<Employees>login(@Param("username")String username,@Param("password")String password);
}
