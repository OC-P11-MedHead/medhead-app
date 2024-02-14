package com.medhead.mshospitalmanagement.infrastructure.repository.speciality;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityJpaRepository  extends CrudRepository<SpecialityJpa, Long> {
    
}
