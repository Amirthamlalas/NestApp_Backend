package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.LeaveCounter;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCounterDao extends CrudRepository<LeaveCounter,Integer> {

    @Query(value = "SELECT `id`, `total`, `casualleave`, `empid`, `sickleave`, `specialleave`, `year` FROM `counter` WHERE `empid`= :empid",nativeQuery = true)
    List<LeaveCounter>Leaves(@Param("empid")Integer empid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `counter` SET `total`= :total ,`casualleave`= :casualleave ,`sickleave`= :sickleave,`specialleave`= :specialleave WHERE `empid`= :empid",nativeQuery = true)
    void updateCounter(@Param("empid") Integer empid, @Param("total")Integer total,@Param("casualleave")Integer casualleave,@Param("sickleave")Integer sickleave,@Param("specialleave")Integer specialleave);
}
