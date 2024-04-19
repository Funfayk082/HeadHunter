package com.adventurer.webapp.dto.summaries;

import com.adventurer.webapp.enums.StatusType;
import com.adventurer.webapp.models.PersonContact;
import com.adventurer.webapp.models.Region;
import com.adventurer.webapp.models.User;
import lombok.Data;

import java.util.List;

@Data
public class GetSummaryDto {
    private Long id;
    private User user;
    private String name;
    private String baseInfo;
    private List<PersonContact> contacts;
    private StatusType status;
    private String photo;
    private Region region;
}
