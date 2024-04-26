package com.ebayscraper;

// Java program to write data in excel sheet using java code

import java.io.File;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {

    public void writer(Map<Integer, Item> treeMap, String path) throws IOException {

        // workbook object
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet
                = workbook.createSheet(" Prices ");

        // creating a row object
        XSSFRow row;
        
        /* 

        // This data needs to be written (Object[])
        Map<Integer, Object[]> playlistData
                = new TreeMap<Integer, Object[]>();

        playlistData.put(
                1,
                new Object[] { "Position", "Song name", "Artists", "Album", "Year", "Genre"});

        int lineCounter = 2;

        for (Integer pos: treeMap.keySet()){
            playlistData.put(lineCounter, new Object[] { String.valueOf(pos),
                    String.valueOf(treeMap.get(pos).getName()),
                    String.valueOf(treeMap.get(pos).getArtist()),
                    String.valueOf(treeMap.get(pos).getAlbum()),
                    String.valueOf(treeMap.get(pos).getYear()),
                    String.valueOf(treeMap.get(pos).getGenre())
            });
            lineCounter++;
        }

        Set<Integer> keyid = playlistData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (int key : keyid) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = playlistData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        */

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File(path + "Ebay_DragonBall_Prices.xlsx"));

        workbook.write(out);
        out.close();
    }
}