package com.example.bankInfo.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.cbr.ed.v2.ED807;

import javax.xml.transform.stream.StreamSource;

@Component
public class XmlParser {

    public ED807 parseXml(MultipartFile file) throws IOException, JAXBException {
        byte[] data = file.getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);

        JAXBContext jaxbContext = JAXBContext.newInstance(ED807.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        InputStreamReader reader = new InputStreamReader(inputStream, "Windows-1251");
        JAXBElement<ED807> root = unmarshaller.unmarshal(new StreamSource(reader), ED807.class);
        return root.getValue();
    }
}