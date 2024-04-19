package com.adventurer.webapp.controllers;

import com.adventurer.webapp.services.TagService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }


    @GetMapping
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "Получение тегов для поиска",
                    content = {
                            @Content(mediaType = "application/json")
                    }
            )
    )
    public ResponseEntity<?> getTagsByName(@RequestParam String name) {
        return ResponseEntity.ok(tagService.getTagsByName(name));
    }
}
