package com.galactros.puc.integrationproject1a.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class FileResourcesUtils {

    public String filebyStream(String fileResourceLocation) throws IOException {
        
        String fileString;

        InputStream resource = getClass().getResourceAsStream(fileResourceLocation);
        try ( BufferedReader reader = new BufferedReader(new InputStreamReader(resource))) {
            fileString = reader.lines()
                    .collect(Collectors.joining(System.lineSeparator()));
        }

        return fileString;
    }

}
