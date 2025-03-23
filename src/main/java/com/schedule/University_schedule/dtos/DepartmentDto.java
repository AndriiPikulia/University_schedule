package com.schedule.University_schedule.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class DepartmentDto {
    private String name;
    private Long id;
    private List<SpecialtyDto> specialties;
    private List<AccountDto> accounts;
}
