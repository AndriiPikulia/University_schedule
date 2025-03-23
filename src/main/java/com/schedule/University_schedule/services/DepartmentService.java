package com.schedule.University_schedule.services;

import com.schedule.University_schedule.domains.Department;
import com.schedule.University_schedule.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Department not found"));
        //needed department exception
    }

    public List<Department> getByIds(List<Long> ids) {
        return departmentRepository.getDepartmentsByIdIn(ids);
    }
}
