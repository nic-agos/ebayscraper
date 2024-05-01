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

    /*This method takes as input the path to an Excel file consisting of a single column where 
    each row contains the link to an eBay product that you want to import. It returns an object map 
    of type Product where the primary key is an integer that is incremented, starting at 1, each time 
    a new link is read from the Excel file */
    
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

            Product tempItem = new Product();
            
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();

                //Check the cell type and format accordingly
                switch (cell.getCellType()) {

                    case STRING:
                        
                        tempItem.setUrl(cell.getStringCellValue());
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
