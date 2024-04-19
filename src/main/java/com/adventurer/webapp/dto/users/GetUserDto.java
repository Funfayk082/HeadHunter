package com.adventurer.webapp.dto.users;

import com.adventurer.webapp.models.Gender;
import com.adventurer.webapp.models.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetUserDto {
    private Long userId;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String authUserEmail;
    private Gender gender;
    private Role authUserRole;
}
