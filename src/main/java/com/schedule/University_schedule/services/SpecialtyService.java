package com.schedule.University_schedule.services;

import com.schedule.University_schedule.domains.Specialty;
import com.schedule.University_schedule.repositories.SpecialtyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public Specialty getById(Long id) {
        return specialtyRepository.findById(id).orElseThrow(() -> new RuntimeException("Special type not found"));
        //Specialty exception
    }

    public List<Specialty> getByIds(List<Long> ids) {
        return specialtyRepository.getSpecialtiesByIdIn(ids);
    }
}
