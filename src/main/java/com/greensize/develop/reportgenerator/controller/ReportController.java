package com.greensize.develop.reportgenerator.controller;

import com.greensize.develop.reportgenerator.service.ReportService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ReportController {

    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }
    
    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "/upload/")
    @ResponseBody
    ResponseEntity uploadExcel(@RequestParam("file") MultipartFile uploadfile, HttpServletRequest request, HttpServletResponse response) throws IOException, InvalidFormatException {
        return reportService.uploadExcel(uploadfile);
    }
}
