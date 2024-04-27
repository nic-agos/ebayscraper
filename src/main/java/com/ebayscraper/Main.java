package com.ebayscraper;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    String inputFilePath = "C:/Users/nicco/Desktop/Test.xlsx";

    //String outputFolder = "";
    String outputFolder = "C:/Users/nicco/Desktop/";

    Controller controller = new Controller();
    controller.calculatePrices(inputFilePath, outputFolder);

  }

}
