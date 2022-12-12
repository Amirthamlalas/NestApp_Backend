package com.nest.NestApp_Backend.dao;


import com.nest.NestApp_Backend.model.SecurityGuard;
import org.springframework.data.repository.CrudRepository;

public interface SecurityDao extends CrudRepository<SecurityGuard,Integer> {
}
