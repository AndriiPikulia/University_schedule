package com.schedule.University_schedule.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ScheduleDto {
    private Long id;
    private String yearOfStudy;
    private SpecialtyDto specialty;
}
