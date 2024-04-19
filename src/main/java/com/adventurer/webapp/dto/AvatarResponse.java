package com.adventurer.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class AvatarResponse {
    private String name;
    private String uri;
    private String type;
    private Long size;
}
