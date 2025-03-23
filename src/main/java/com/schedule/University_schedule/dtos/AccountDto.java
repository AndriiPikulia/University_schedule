package com.schedule.University_schedule.dtos;

import com.schedule.University_schedule.domains.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class AccountDto {
    private Long id;
    private UserNameDto userName;
    private String password;
    private String email;
    private AccessLevel accessLevel;
    private List<DepartmentDto> departments;
    private List<SpecialtyDto> specialties;
}
