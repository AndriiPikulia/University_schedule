package com.schedule.University_schedule.domains;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class UserName {
    private String firstName;
    private String lastName;
    private String middleName;
}
