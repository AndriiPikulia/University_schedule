package com.schedule.University_schedule.repositories;

import com.schedule.University_schedule.domains.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> getDepartmentsByIdIn(List<Long> ids);
}
