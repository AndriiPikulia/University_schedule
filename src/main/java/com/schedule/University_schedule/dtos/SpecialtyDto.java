package com.schedule.University_schedule.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SpecialtyDto {
    private Long id;
    private String name;
    private String subjects;
    private String fieldOfStudy;
    private List<AccountDto> accounts;
    private List<DepartmentDto> departments;
}
