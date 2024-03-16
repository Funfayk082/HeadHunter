package com.adventurer.webapp.dto.users;

import com.adventurer.webapp.models.Gender;
import com.adventurer.webapp.models.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CreateUserRequestDto {
    private String surname;
    private String name;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private String email;
    private Gender gender;
    private String login;
    private String password;
    private Role role;
}
