package com.adventurer.webapp.dto.users;

import com.adventurer.webapp.models.Gender;

import java.time.LocalDate;

public class CreateUserRequestDto {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
    private Gender gender;
}
