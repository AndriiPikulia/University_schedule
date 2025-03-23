package com.schedule.University_schedule.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserNameDto {
    private String firstName;
    private String lastName;
    private String middleName;
}
