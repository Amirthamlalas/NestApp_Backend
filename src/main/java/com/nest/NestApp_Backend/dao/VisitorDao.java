package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.controller.SecurityController;
import com.nest.NestApp_Backend.model.EmployeeLog;
import com.nest.NestApp_Backend.model.VisitorLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorDao extends CrudRepository<VisitorLog,Integer> {


    @Query(value = "SELECT `id`, `date`, `entry_time`,`name`, `purpose`, `whom_to_meet`, `exit_time` FROM `visitor` WHERE `date`= :date",nativeQuery = true)
    List<VisitorLog> searchlog(@Param("date")String date);

}
