package com.schedule.University_schedule.dtos;

import lombok.Data;

@Data
public class ScheduleDto {
    private Long id;
    private String yearOfStudy;
    private SpecialtyDto specialty;
}
