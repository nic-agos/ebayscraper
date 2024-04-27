package com.ebayscraper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
    
    public Map<Integer, Product> reader(String inputPath) throws IOException{

        Map<Integer, Product> treeMap = new TreeMap<>();

        File inputFile = new File(inputPath);

        FileInputStream file = new FileInputStream(inputFile);

        //Create Workbook instance holding reference to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Get first/desired sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        int treeMapKey = 2;

        //Iterate through each rows one by one
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {

            Row row = rowIterator.next();

            //For each row, iterate through all the columns
            Iterator<Cell> cellIterator = row.cellIterator();

            int column = 1;
            Product tempItem = new Product();
            
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                //Check the cell type and format accordingly
                switch (cell.getCellType()) {

                    case STRING:
                        
                        if (column == 1){
                            tempItem.setName(cell.getStringCellValue());
                        }
                        if (column == 2){
                            tempItem.setUrl(cell.getStringCellValue());
                        }

                        column += 1;
                        break;
                }
            }

            treeMap.put(treeMapKey, tempItem);
            treeMapKey += 1;

        }
    
        file.close();
        workbook.close();

        return treeMap;
        
    }

}
