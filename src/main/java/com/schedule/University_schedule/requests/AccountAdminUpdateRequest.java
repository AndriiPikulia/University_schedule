package com.schedule.University_schedule.requests;

import com.schedule.University_schedule.domains.AccessLevel;
import com.schedule.University_schedule.dtos.UserNameDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.List;

@Builder
public record AccountAdminUpdateRequest(
        @NotNull(message = "Email cannot be empty!") @Pattern(regexp = "^([a-zA-Z0-9_.]+@knu\\.ua$)",
                message = "Email must contain only english letters and must be @knu.ua")
        String email,
        @NotNull(message = "Password cannot be empty!") @Size(min = 8, max = 100)
        @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){8,100}$",
                message = "Password must contain at least 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
        String password,
        @NotNull(message = "User name cannot be empty!") @Size(min = 1)
        UserNameDto userName,
        @NotNull
        AccessLevel accessLevel,
        @NotNull
        List<Long> specialtyIds,
        @NotNull
        List<Long> departmentIds) { }