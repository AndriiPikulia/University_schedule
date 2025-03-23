package com.schedule.University_schedule.requests;

import com.schedule.University_schedule.domains.AccessLevel;
import com.schedule.University_schedule.dtos.UserNameDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record AccountAdminUpdateRequest(
        @NotNull
        String email,
        @NotNull  @Size(min = 8, max = 100)
        String password,
        @NotNull
        UserNameDto userName,
        @NotNull
        AccessLevel accessLevel,
        @NotNull
        List<Long> specialtyIds,
        @NotNull
        List <Long> departmentIds)  {
}
