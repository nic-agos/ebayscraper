package com.ebayscraper;

public class Product {

    private String name;
    private String url;
    private String price;
    private String seller;

    public Product(){

    }

    public Product(String productName, String productPrice, String productSeller, String productUrl){
        
        name = productName;
        url = productUrl;
        seller = productSeller;
        price = productPrice;


    }


    public String getName(){
        return this.name;
    }

    public String getUrl(){
        return this.url;
    }

    public String getPrice(){
        return this.price;
    }

    public String getSeller(){
        return this.seller;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setSeller(String seller){
        this.seller = seller;
    }
    
}
