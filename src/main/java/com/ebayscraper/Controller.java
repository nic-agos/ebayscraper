package com.ebayscraper;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
    
    public void calculatePrices(String inputFilePath, String outputFolder) throws IOException{

        WriteDataToExcel writerClass = new WriteDataToExcel();

        ReadDataFromExcel readerClass = new ReadDataFromExcel();

        Map<Integer, Item> treeMapReaden = new TreeMap<>();
        treeMapReaden = readerClass.reader(inputFilePath);

        int treeMapReadenSize = treeMapReaden.size();

        System.out.println("\nReaded " + treeMapReadenSize + " items from " + inputFilePath + "\n");

        Scraper scraper = new Scraper();

        for (Integer pos: treeMapReaden.keySet()){
            String tempUrl = String.valueOf(treeMapReaden.get(pos).getUrl());
            String tempName = String.valueOf(treeMapReaden.get(pos).getName());

            Double tempPrice = scraper.scrapeItemPrice(tempUrl);
            treeMapReaden.get(pos).setPrice(tempPrice);
            
            System.out.println("Price for " + tempName + " is: " + tempPrice);
        }

        String outputPath = writerClass.writer(treeMapReaden, outputFolder);

        System.out.println("\nAll prices written in " + outputPath + "\n");
        
    }

}
