package com.csvdatahandling.basicproblems.readandcountrowsscvfile;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRowsInCSVFile {

    public static void main(String[] args) {

        String fileName = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\employdetail.csv";

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {

            int countLines=0;
            while (reader.readNext() != null){
                countLines++;
            }
            System.out.println("Number of records in the file is : " + ((countLines==0)? 0 : countLines-1));

        } catch (IOException | CsvValidationException e ) {
            System.out.println(e);
        }
    }
}
