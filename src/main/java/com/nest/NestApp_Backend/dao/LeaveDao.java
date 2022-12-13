package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.LeaveApplication;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeaveApplication,Integer> {

    @Query(value = "SELECT  e.`empid`, e.`name`,l.leavetype,l.status,l.from_data,l.to_date  FROM `employees`e JOIN leaveapp l ON e.`empid`=l.empid",nativeQuery = true)
    List<Map<String,String>> viewLeave();

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaveapp` SET `status`= :status WHERE `empid`=:empid",nativeQuery = true)
    List<LeaveApplication> updateStatus(@Param("empid") Integer empid,@Param("status")String status);
}
