package com.schedule.University_schedule.repositories;

import com.schedule.University_schedule.domains.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long > {
    List<Specialty> getSpecialtiesByIdIn(List<Long> ids);
}
