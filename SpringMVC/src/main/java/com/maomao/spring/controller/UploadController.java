package com.maomao.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestPart MultipartFile file) throws IOException {
        System.out.println("Name: " + file.getName());
        System.out.println("OriginalFilename: " + file.getOriginalFilename());
        System.out.println("ContentType: " + file.getContentType());
        File dest = new File("/tmp/spring/temp.png");
        if (dest.isFile() && !dest.exists()) {
            dest.createNewFile();
        }
        file.transferTo(dest);
        return "{\"success\"}";
    }
}
