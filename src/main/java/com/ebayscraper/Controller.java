package com.ebayscraper;

import java.io.IOException;
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

        for (Integer pos: treeMapReaden.keySet()){
            String tempUrl = String.valueOf(treeMapReaden.get(pos).getUrl());
            String tempName = String.valueOf(treeMapReaden.get(pos).getName());

            Product tempProduct = scraper.scrapeProduct(tempUrl);
            Double tempPrice = tempProduct.getPrice();
            String tempSeller = tempProduct.getSeller();
            treeMapReaden.get(pos).setPrice(tempPrice);
            treeMapReaden.get(pos).setSeller(tempSeller);
            
            System.out.println("Price for product # " + counter + " -> " + tempName + " is: " + tempPrice + " EUR");

            counter += 1;
        }

        String outputPath = writerClass.writer(treeMapReaden, outputFolder);

        System.out.println("\nAll prices written in " + outputPath + "\n");
        
    }

}
