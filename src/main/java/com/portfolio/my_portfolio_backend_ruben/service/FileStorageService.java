package com.portfolio.my_portfolio_backend_ruben.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        if(file.isEmpty()){
            throw new IOException("El archivo está vacío.");
        }

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if(originalFilename!=null){
            int dotIndex = originalFilename.lastIndexOf('.');
            if(dotIndex > 0){
                extension = originalFilename.substring(dotIndex);
            }
        }

        //f47ac10b-58cc-4372...jpg
        String fileName = UUID.randomUUID().toString() + extension;

        //creación de la ruta
        Path filePath = Paths.get(uploadDir, fileName).normalize();

        //copia del archivo al destino
        Files.copy(file.getInputStream(), filePath);

        //retorno de la url relativa
        return "/img/projects" + fileName;
    }
}
