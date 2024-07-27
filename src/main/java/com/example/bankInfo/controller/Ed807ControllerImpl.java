package com.example.bankInfo.controller;


import com.example.bankInfo.converter.FileConverter;
import com.example.bankInfo.entity.Ed807Entity;
import com.example.bankInfo.parser.XmlParser;
import com.example.bankInfo.service.Ed807Service;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.cbr.ed.v2.ED807;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



@RestController
@RequestMapping("/xml-bic")
@RequiredArgsConstructor
public class Ed807ControllerImpl {

    private final Ed807Service ed807Service;
    private final FileConverter fileConverter;
    private final XmlParser xmlParser;

    @PostMapping(value = "/upload")
    public ED807 createXmlBic(@RequestPart("file") MultipartFile file) throws IOException {
        try {
            ED807 ed807 = xmlParser.parseXml(file);
            ed807Service.createEd807(ed807);
            return ed807;
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }


//    @PutMapping("/{id}")
//    public ED807 updateEd807(@PathVariable Long id, @RequestBody ED807 ed807){
//
//    }

}
