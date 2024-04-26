package com.ebayscraper;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
  
    String url = "https://www.ebay.it/itm/364552298267?_trkparms=amclksrc%3DITM%26aid%3D777008%26algo%3DPERSONAL.TOPIC%26ao%3D1%26asc%3D264197%26meid%3D0b85fb7148a94bbfb35a6daea6ba67bf%26pid%3D101770%26rk%3D1%26rkt%3D1%26itm%3D364552298267%26pmt%3D1%26noa%3D1%26pg%3D4375194%26algv%3DRecentlyViewedItemsV2&_trksid=p4375194.c101770.m146925&_trkparms=parentrq%3A1a7fbf1d18f0a5519ac9b2e6ffffb312%7Cpageci%3A31aa54e0-03cd-11ef-9a1c-c2550df5d201%7Ciid%3A1%7Cvlpname%3Avlp_homepage";
    Scraper scraper = new Scraper();
    Double price = scraper.scrapeItem(url);

    System.out.println(price);
  }

}
