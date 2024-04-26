package com.ebayscraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scraper {

    public void scrapeItem(String url) throws IOException{

        String webUrl = url;
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

        Document doc = Jsoup.connect(webUrl)
        .userAgent(userAgent)
        .get();

        System.out.println(doc.body().select("div.x-price-primary").select("span.ux-textspans").text());


    /* 

    Element item = doc.select("div.x-price-primary");

    System.out.println("Title: " + item);



    Elements listings = doc.select("div.x-price-primary");

    for (Element listing : listings) {

      String title = listing.select("div.s-item__title").text();
      String urlWeb = listing.select("a.s-item__link").attr("href");
      String price = listing.select("span.s-item__price").text();

      String details = listing.select("div.s-item__subtitle").text();
      String sellerInfo = listing.select("span.s-item__seller-info-text").text();
      String shippingCost = listing.select("span.s-item__shipping").text();
      String location = listing.select("span.s-item__location").text();
      String sold = listing.select("span.s-item__quantity-sold").text();

      System.out.println("Title: " + title);
      System.out.println("URL: " + urlWeb);
      System.out.println("Price: " + price);
      System.out.println("Details: " + details);
      System.out.println("Seller: " + sellerInfo);
      System.out.println("Shipping: " + shippingCost);
      System.out.println("Location: " + location);
      System.out.println("Sold: " + sold);

      System.out.println("=".repeat(50));

      
    }

    */

    }
    
    

}
