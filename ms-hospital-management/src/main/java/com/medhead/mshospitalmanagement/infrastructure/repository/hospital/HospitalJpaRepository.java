package com.medhead.mshospitalmanagement.infrastructure.repository.hospital;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalJpaRepository extends CrudRepository<HospitalJpa, Long> {
    @Query("SELECT DISTINCT h FROM HospitalJpa h JOIN h.specialities s WHERE s.uuid = :uuid")
    Iterable<HospitalJpa> findHospitalsBySpeciality(@Param("uuid") String uuid);

    Optional<HospitalJpa> findById(Long id);
}
