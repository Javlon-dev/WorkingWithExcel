package com.company.controller;

import com.company.entity.UniversityDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.css.RGBColor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Controller {

    public static void writeStudent(String pathname, List<UniversityDTO> universityDTOList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("UniversityName");
        sheet.setColumnWidth(0, 4500);
        sheet.setColumnWidth(1, 4500);
        sheet.setColumnWidth(2, 8000);
        sheet.setColumnWidth(3, 17000);
        Row firstRow = sheet.createRow(0);
        firstRow.setHeight((short) 1000);


        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);


        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
//        font.setBold(true);
        style.setFont(font);

        Cell cell = null;
        cell = firstRow.createCell(0);
        cell.setCellValue("№");
        cell.setCellStyle(style);

        cell = firstRow.createCell(1);
        cell.setCellValue("Domains");
        cell.setCellStyle(style);

        cell = firstRow.createCell(2);
        cell.setCellValue("Web Pages");
        cell.setCellStyle(style);

        cell = firstRow.createCell(3);
        cell.setCellValue("Names");
        cell.setCellStyle(style);


        int rowCount = 1;
        for (UniversityDTO universityDTO : universityDTOList) {
            Row row = sheet.createRow(rowCount);
            row.setHeight((short) 500);

            CellStyle newStyle = workbook.createCellStyle();
            newStyle.setAlignment(HorizontalAlignment.CENTER);
            newStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            Font newFont = workbook.createFont();
            newFont.setBold(true);
            newStyle.setFont(newFont);

            cell = row.createCell(0);
            cell.setCellValue(rowCount++);
            cell.setCellStyle(newStyle);

            cell = row.createCell(1);
            cell.setCellValue(universityDTO.getDomains());
            cell.setCellStyle(newStyle);

            cell = row.createCell(2);
            cell.setCellValue(universityDTO.getWeb_pages());
            cell.setCellStyle(newStyle);


            cell = row.createCell(3);
            cell.setCellValue(universityDTO.getName());
            cell.setCellStyle(newStyle);

        }

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(pathname);
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
