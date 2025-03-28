package com.schedule.University_schedule.dtos;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentDto {
    private String name;
    private Long id;
    private List<SpecialtyDto> specialties;
    private List<AccountDto> accounts;
}
