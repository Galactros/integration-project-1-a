package com.galactros.puc.integrationproject1a.controller;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    @GetMapping("/result")
    public String result() throws IOException {
        File file = new ClassPathResource("/static/result.html").getFile();

        String str = FileUtils.readFileToString(file, "UTF-8");

        return str;
    }
}
