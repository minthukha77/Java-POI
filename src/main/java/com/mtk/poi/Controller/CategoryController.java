package com.mtk.poi.Controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.mtk.poi.Service.ExcelService;


@RestController
@RequestMapping("/categories")
public class CategoryController {
    
    private final ExcelService service;

    public CategoryController(ExcelService service){
        this.service = service;
    }

    @RequestMapping("/excel")
    public ResponseEntity<InputStreamSource> download() throws IOException {

        String filename = "categories.xlsx";

        ByteArrayInputStream actualData = service.getActualData();
        InputStreamSource file = new InputStreamResource(actualData);


        return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+filename)
                        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                        .body(file);
               




    }
    

    



}
