package com.hackathon.gmit.service;

import com.hackathon.gmit.exeption.ImageHandleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ImageService {
    public final String FOLDER_DEFAULT = "images";
    public final String IMAGE_DEFAULT = "default.jpg";

    @Autowired
    ServletContext app;

    private Path getPath(String folder, String fileName) {
        File dir = Paths.get(app.getRealPath("/files"), folder).toFile();
        log.info(dir.getAbsolutePath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return Paths.get(dir.getAbsolutePath(), fileName);
    }

    public byte[] read(String folder, String filename) {
        Path path = this.getPath(folder, filename);
        try {
            return Files.readAllBytes(path);
        } catch (IOException e) {
            Path pathError = this.getPath(this.FOLDER_DEFAULT, this.IMAGE_DEFAULT);
            try {
                return Files.readAllBytes(pathError);
            } catch (IOException e1) {
                return null;
            }
        }
    }

    public void delete(String folder, String file) {
		Path path = this.getPath(folder, file);
		path.toFile().delete();
    }

    public List<String> list(String folder) {
        List<String> filenames = new ArrayList<>();
        File fileFolder = Paths.get(app.getRealPath("/files/"), folder).toFile();
        if (fileFolder.exists()) {
            File[] files = fileFolder.listFiles();
            for (File file : files) {
                filenames.add(file.getName());
            }
        }
        return filenames;
    }

    public String save(String folder, MultipartFile[] multipart) {
        List<String> filenames = new ArrayList<>();
        try {
            for (MultipartFile M : multipart) {
                String name = System.currentTimeMillis() + M.getOriginalFilename();
                String filename = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
                Path path = this.getPath(folder, filename);
                try {
                    M.transferTo(path);
                    filenames.add(filename);
                } catch (Exception e) {
                    e.printStackTrace();// TODO: handle exception
                }
            }
        } catch (Exception e) {
            throw new ImageHandleException(e.getMessage());
        }
        if (filenames.size() == 0) {
            return null;
        }
        return filenames.get(0);
    }
}
