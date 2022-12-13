package com.nest.NestApp_Backend.dao;

import com.nest.NestApp_Backend.model.LeaveCounter;
import org.springframework.data.repository.CrudRepository;

public interface LeaveCounterDao extends CrudRepository<LeaveCounter,Integer> {
}
