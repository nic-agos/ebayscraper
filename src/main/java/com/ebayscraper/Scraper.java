package com.ebayscraper;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Scraper {

  public Double scrapeProductPrice(String url) throws IOException{

    String webUrl = url;
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

    Document doc = Jsoup.connect(webUrl)
    .userAgent(userAgent)
    .get();

    String rawPrice = doc.body().select("div.x-price-primary").select("span.ux-textspans").text();
    
    String stringPrice = rawPrice.replace("EUR ", "");

    stringPrice = stringPrice.replace(",", ".");

    Double price = Double.parseDouble(stringPrice);

    return price;
  } 

  public String scrapeProductSeller(String url) throws IOException{

    String webUrl = url;
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

    Document doc = Jsoup.connect(webUrl)
    .userAgent(userAgent)
    .get();
    
    String rawSeller = doc.select("div.d-stores-info-categories__container__info__section").text();

    rawSeller = rawSeller.substring(0, rawSeller.indexOf("%"));

    String seller = rawSeller.substring(0,rawSeller.lastIndexOf(" "));
    
    return seller;

  }

  public Product scrapeProduct(String url) throws IOException{

    String webUrl = url;
    String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.102 Safari/537.36";

    Document doc = Jsoup.connect(webUrl)
    .userAgent(userAgent)
    .get();
    
    String rawSeller = doc.select("div.d-stores-info-categories__container__info__section").text();

    rawSeller = rawSeller.substring(0, rawSeller.indexOf("%"));

    String seller = rawSeller.substring(0,rawSeller.lastIndexOf(" "));

    String rawPrice = doc.body().select("div.x-price-primary").select("span.ux-textspans").text();
    
    String stringPrice = rawPrice.replace("EUR ", "");

    stringPrice = stringPrice.replace(",", ".");

    Double price = Double.parseDouble(stringPrice);

    String rawName = doc.select("div.x-item-title").text();

    Product product = new Product();

    product.setName(rawName);
    product.setPrice(price);
    product.setUrl(url);
    product.setSeller(seller);
    
    return product;

  }

}
