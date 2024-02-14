package com.medhead.emergencymanagement.infrastructure.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.medhead.emergencymanagement.domain.entities.Emergency;

@Repository
public interface EmergencyRepository extends CrudRepository<Emergency, Long>{
    
}
