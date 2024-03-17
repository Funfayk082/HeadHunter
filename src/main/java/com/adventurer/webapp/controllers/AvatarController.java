package com.adventurer.webapp.controllers;

import com.adventurer.webapp.dto.AvatarResponse;
import com.adventurer.webapp.services.StorageService;
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
    public ResponseEntity<Resource> download(@RequestParam String filename) {
        Resource resource = storageService.loadAsResource(filename);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        String name = storageService.store(file);

        String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(name)
                .toUriString();

        return new ResponseEntity<>(
                new AvatarResponse(name, uri, file.getContentType(), file.getSize()),
                HttpStatusCode.valueOf(200)
        );
    }
}
