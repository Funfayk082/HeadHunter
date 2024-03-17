package com.adventurer.webapp.services;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
    void init();

    String store(MultipartFile file, String filename);

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
