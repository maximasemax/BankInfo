package com.example.bankInfo.controller;


import com.example.bankInfo.converter.FileConverter;
import com.example.bankInfo.exception.CustomEd807Exception;
import com.example.bankInfo.parser.XmlParser;
import com.example.bankInfo.service.Ed807Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.cbr.ed.v2.ED807;

import java.io.IOException;


@RestController
@RequestMapping("/xml-bic")
@RequiredArgsConstructor
@Tag(name = "Ed807", description = "операции по работе с ed807")
public class Ed807ControllerImpl {

    private final Ed807Service ed807Service;
    private final XmlParser xmlParser;

    @PostMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Operation(description = "Загрузка файла xml")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Файл успешно загружен и обработан")})
    public ResponseEntity<Object> createXmlBic(@RequestPart("file") MultipartFile file) throws CustomEd807Exception {
        try {
            ED807 ed807 = xmlParser.parseXml(file);
            ed807Service.createEd807(ed807);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IOException | JAXBException e) {
            throw new CustomEd807Exception("Внутренняя ошибка сервера");
        }
    }


//    @PutMapping("/{id}")
//    public ED807 updateEd807(@PathVariable Long id, @RequestBody ED807 ed807){
//
//    }

}
