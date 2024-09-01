package com.example.bankInfo.converter;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FileConverter {


    /**
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());
        try (InputStream inputStream = multipartFile.getInputStream();
             OutputStream outputStream = new FileOutputStream(file);
             Reader reader = new InputStreamReader(inputStream, "UTF-8");
             Writer writer = new OutputStreamWriter(outputStream, "UTF-8")) {

            char[] buffer = new char[4096];
            int length;
            while ((length = reader.read(buffer)) > 0) {
                writer.write(buffer, 0, length);
            }
        }
        return file;
    }
}
