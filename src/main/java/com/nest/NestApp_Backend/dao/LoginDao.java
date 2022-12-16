package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.EmployeeLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LoginDao extends CrudRepository<EmployeeLog,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `employeelogin` SET `exit_time`= :exit_time WHERE `empid`= :empid",nativeQuery = true)
    void updateExit(@Param("exit_time")String exit_time,@Param("empid")Integer empid);
}
