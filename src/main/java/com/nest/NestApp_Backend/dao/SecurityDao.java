package com.nest.NestApp_Backend.dao;


import com.nest.NestApp_Backend.model.Employees;
import com.nest.NestApp_Backend.model.SecurityGuard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityGuard,Integer> {

    @Query(value = "SELECT * FROM security WHERE `username`= :username AND `password`= :password",nativeQuery = true)
    List<SecurityGuard> login(@Param("username")String username, @Param("password")String password);
}
