package com.adventurer.webapp.dto.users;

import com.adventurer.webapp.models.Gender;
import com.adventurer.webapp.models.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateUserRequestDto {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
    private Gender gender;
    private String login;
    private String password;
    private Role role;
}
