package com.greensize.develop.reportgenerator.service;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ReportService {

    public ResponseEntity uploadExcel(MultipartFile uploadfile) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(uploadfile.getInputStream());
        Sheet datatypeSheet = workbook.getSheetAt(0);

        for (Row currentRow : datatypeSheet) {
            for (Cell currentCell : currentRow) {
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                if (currentCell.getCellTypeEnum() == CellType.STRING) {
                    System.out.print(currentCell.getStringCellValue() + "--");
                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                    System.out.print(currentCell.getNumericCellValue() + "--");
                }
            }
            System.out.println();
        }
        return new ResponseEntity("done", HttpStatus.OK);
    }
}
