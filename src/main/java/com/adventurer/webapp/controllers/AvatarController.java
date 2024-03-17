package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.AvatarResponse;
import com.adventurer.webapp.services.StorageService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/avatar")
public class AvatarController {
    private final StorageService storageService;

    public AvatarController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/download")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Получение фотографии по названию (в процессе)",
                    content = {
                            @Content(mediaType = "image/png")
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "НЕТ ТУТ НИКОГО ТЫ ПОНИМАЕШЬ????",
                    content = {
                            @Content(mediaType = "image/png")
                    }
            )
    })
    public ResponseEntity<Resource> download(@RequestParam String filename) {
        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Загрузить фото",
                    content = {
                            @Content(mediaType = "image/png")
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "НЕТ ТУТ НИКОГО ТЫ ПОНИМАЕШЬ????",
                    content = {
                            @Content(mediaType = "image/png")
                    }
            )
    })
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam String filename) {
        String name = storageService.store(file, filename);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        return new ResponseEntity<>(
                new AvatarResponse(filename, uri, file.getContentType(), file.getSize()),
                HttpStatusCode.valueOf(200)
        );
    }
}
