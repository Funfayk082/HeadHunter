package com.adventurer.webapp.dto.summaries;

import com.adventurer.webapp.enums.StatusType;
import com.adventurer.webapp.models.PersonContact;
import com.adventurer.webapp.models.Region;
import com.adventurer.webapp.models.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class CreateSummaryRequestDto {
    private User user;
    private String name;
    private String baseInfo;
    private List<PersonContact> contacts;
    private StatusType status;
    private String photo;
    private Region region;
}
