package com.csvdatahandling.intermediateproblems.searcharecordincsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class SearchRecordInCSV {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\employdetail.csv";

        String target = "Om yadav";

        try(CSVReader  reader = new CSVReader(new FileReader(fileName))){

            String [] column;
            while ((column = reader.readNext()) != null ){

                if(column[1].equals(target)){
                    System.out.println("ID: " + column[0] + ", Name: " + column[1] + ", Age: " + column[2] + ", Marks: " + column[3]);
                }
             }

        }catch (IOException | CsvValidationException e){
            System.out.println(e);
        }
    }
}
