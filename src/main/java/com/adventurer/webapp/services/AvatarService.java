package com.adventurer.webapp.services;

import com.adventurer.webapp.config.StorageConfig;
import com.adventurer.webapp.exceptions.FileNotFoundException;
import com.adventurer.webapp.exceptions.StorageException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class AvatarService implements StorageService{
    private final Path rootLocation;

    @Autowired
    public AvatarService(StorageConfig props) {
        this.rootLocation = Paths.get(props.getLocation());
    }

    @Override
    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Не удалось инициализировать место хранения", e);
        }
    }

    @Override
    public String store(MultipartFile file, String filename) {
        try {
            if(file.isEmpty()) throw new StorageException("Не удалось сохранить пустой файл " + filename);
            if (filename.contains("..")) throw new StorageException("Невозможно сохранить файл с относительным путем вне текущего каталога " + filename);
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Не удалось сохранить файл " + filename, e);
        }
        return filename;
    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else throw new FileNotFoundException("Не удалось прочитать файл: " + filename);
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Не удалось прочитать файл: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }
}
