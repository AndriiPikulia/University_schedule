package com.schedule.University_schedule.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class SpecialtyDto {
    private Long id;
    private String name;
    private String subjects;
    private String fieldOfStudy;
    private List<AccountDto> accounts;
    private List<DepartmentDto> departments;
}
