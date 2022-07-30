/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    ImageService imageService;

    @GetMapping("/{folder}/{file}")
    public byte[] download(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        return imageService.read(folder, file);
    }

    @DeleteMapping("/delete/{folder}/{file}")
    public void delete(@PathVariable("folder") String folder, @PathVariable("file") String file) {
        imageService.delete(folder, file);
    }

    @PostMapping("/upload/{folder}")
    public String upload(@PathVariable("folder") String folder, @PathParam("file") MultipartFile[] file) {
        System.out.println(file);
        return imageService.save(folder, file);
    }
}
