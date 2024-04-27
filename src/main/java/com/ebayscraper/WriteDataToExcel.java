package com.ebayscraper;

// Java program to write data in excel sheet using java code

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Date;

public class WriteDataToExcel {

    public String writer(Map<Integer, Product> treeMap, String outputFolder) throws IOException {

        // Create a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // Create a spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Prices ");

        // Declare a row object
        XSSFRow row;
        
        // This data needs to be written (Object[])
        Map<Integer, Object[]> itemsData = new TreeMap<Integer, Object[]>();

        itemsData.put(1, new Object[] { "Name", "Price", "Seller", "URL" });

        int lineCounter = 2;

        for (Integer pos: treeMap.keySet()){
            itemsData.put(lineCounter, new Object[] {
                    String.valueOf(treeMap.get(pos).getName()),
                    String.valueOf(treeMap.get(pos).getPrice()),
                    String.valueOf(treeMap.get(pos).getSeller()),
                    String.valueOf(treeMap.get(pos).getUrl()),
            });
            lineCounter++;
        }

        Set<Integer> keyid = itemsData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (int key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = itemsData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateTime = dateFormat.format(currentDate);

        // writing the workbook into the file
        String outputPath = outputFolder + "Ebay_DragonBall_Prices_" + currentDateTime + ".xlsx";

        File outputFile = new File(outputPath);
        FileOutputStream out = new FileOutputStream(outputFile);

        workbook.write(out);
        out.close();
        workbook.close();

        return outputPath;
    }
}