package com.ebayscraper;

public class Item {

    private String name;
    private String url;
    private Double price;

    public String getName(){
        return this.name;
    }

    public String getUrl(){
        return this.url;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void setPrice(Double price){
        this.price = price;
    }
    
}