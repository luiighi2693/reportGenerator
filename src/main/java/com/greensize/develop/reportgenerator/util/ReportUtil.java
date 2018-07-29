package com.greensize.develop.reportgenerator.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by greensize-backend on 13/7/2018.
 */
public class ReportUtil {

//    public static void ApachePOIExcelRead() {
//        try {
//            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
//            Workbook workbook = new XSSFWorkbook(excelFile);
//            Sheet datatypeSheet = workbook.getSheetAt(0);
//            Iterator<Row> iterator = datatypeSheet.iterator();
//
//            while (iterator.hasNext()) {
//
//                Row currentRow = iterator.next();
//                Iterator<Cell> cellIterator = currentRow.iterator();
//
//                while (cellIterator.hasNext()) {
//
//                    Cell currentCell = cellIterator.next();
//                    //getCellTypeEnum shown as deprecated for version 3.15
//                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
//                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
//                        System.out.print(currentCell.getStringCellValue() + "--");
//                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
//                        System.out.print(currentCell.getNumericCellValue() + "--");
//                    }
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static XSSFWorkbook generateDefaultReport(LinkedHashMap<String, Object> data) {

        LinkedHashMap<String, Object> header = SchemaDefaultUtil.getHeaderContext();
        String labelSheet = SchemaDefaultUtil.getReportName();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(labelSheet);

        //header
        Row row = sheet.createRow(1);

        header.forEach((key, value) -> {
            Cell cell = row.createCell(new Integer(key) - 1);
            cell.setCellValue((String) ((Map<String, Object>) value).get("value"));
        });

        final Integer[] i = new Integer[1];

        data.forEach((key, value) -> {
            //content
            Row rowData = sheet.createRow((new Integer(key) + 2) - 1);

            i[0] = 1;

            ((Map<String, Object>) value).entrySet().forEach(column -> {
                Cell cell = rowData.createCell( i[0] - 1);
                i[0]++;
                cell.setCellValue((String) (column.getValue()));
            });
        });

        //fix Cells
        int columnsLength = ((Map)data.get("1")).size();

        for (int index=0; index<columnsLength; index++){
           sheet.autoSizeColumn(index);
        }

        return workbook;
    }

    public static XSSFWorkbook generateReport(String labelSheet, LinkedHashMap<String, Object> header, LinkedHashMap<String, Object> data) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(labelSheet);

        //header
        Row row = sheet.createRow(1);

        header.forEach((key, value) -> {
            Cell cell = row.createCell(new Integer(key) - 1);
            cell.setCellValue((String) ((Map<String, Object>) value).get("value"));
        });

        final Integer[] i = new Integer[1];

        data.forEach((key, value) -> {
            //content
            Row rowData = sheet.createRow((new Integer(key) + 2) - 1);

            i[0] = 1;

            ((Map<String, Object>) value).entrySet().forEach(column -> {
                Cell cell = rowData.createCell( i[0] - 1);
                i[0]++;
                cell.setCellValue((String) (column.getValue()));
            });
        });

        //fix Cells
        int columnsLength = ((Map)data.get("1")).size();

        for (int index=0; index<columnsLength; index++){
            sheet.autoSizeColumn(index);
        }

        return workbook;
    }

    public static void writeDefaultreport(LinkedHashMap<String, Object> data) {
        XSSFWorkbook workbook = generateDefaultReport(data);
        generateReportFromBook(workbook);
    }

    public static void writeReport(String labelSheet, LinkedHashMap<String, Object> header, LinkedHashMap<String, Object> data) {
        XSSFWorkbook workbook = generateReport(labelSheet, header, data);
       generateReportFromBook(workbook);
    }

    private static void generateReportFromBook( XSSFWorkbook workbook){
        try {
            FileOutputStream outputStream = new FileOutputStream(SchemaDefaultUtil.getReportExportPath() + SchemaDefaultUtil.getRandomReportName());
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}