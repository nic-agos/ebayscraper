package com.ebayscraper;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
    
    public void calculatePrices(String inputFilePath, String outputFolder) throws IOException{

        WriteDataToExcel writerClass = new WriteDataToExcel();

        ReadDataFromExcel readerClass = new ReadDataFromExcel();

        Map<Integer, Product> treeMapReaden = new TreeMap<>();
        treeMapReaden = readerClass.reader(inputFilePath);

        int treeMapReadenSize = treeMapReaden.size();

        System.out.println("\nReaded " + treeMapReadenSize + " items from " + inputFilePath + "\n");

        Scraper scraper = new Scraper();

        int counter = 1;

        long start = System.nanoTime();

        for (Integer pos: treeMapReaden.keySet()){
            String tempUrl = String.valueOf(treeMapReaden.get(pos).getUrl());

            Product tempProduct = scraper.scrapeProduct(tempUrl);
            String tempPrice = tempProduct.getPrice();
            String tempSeller = tempProduct.getSeller();
            String tempName = tempProduct.getName();

            treeMapReaden.get(pos).setPrice(tempPrice);
            treeMapReaden.get(pos).setSeller(tempSeller);
            treeMapReaden.get(pos).setName(tempName);
            
            System.out.println("Price for product # " + counter + " -> " + tempName + " is: " + tempPrice + " EUR");

            counter += 1;
        }

        long end = System.nanoTime();
        long elapsedTime = (end - start) / 1000000000;

        String outputPath = writerClass.writer(treeMapReaden, outputFolder);


        System.out.println("\nScraping time: " + elapsedTime + " seconds");

        System.out.println("\nAll prices written in " + outputPath + "\n");
        
    }

}
