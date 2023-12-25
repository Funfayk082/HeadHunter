package com.adventurer.webapp.dto.users;

import com.adventurer.webapp.models.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class GetUserDto {
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
    private Gender gender;
}
