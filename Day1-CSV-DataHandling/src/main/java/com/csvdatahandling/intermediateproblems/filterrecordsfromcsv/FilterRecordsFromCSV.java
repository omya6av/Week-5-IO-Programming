package com.csvdatahandling.intermediateproblems.filterrecordsfromcsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterRecordsFromCSV {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\studentdetails.csv";

        try(CSVReader reader = new CSVReader(new FileReader(fileName))){

            String column[];
            while((column = reader.readNext()) != null){
                int marks = Integer.parseInt(column[3]);

                // Check if marks > 80
                if (marks > 80) {
                    System.out.println("ID: " + column[0] + ", Name: " + column[1] + ", Age: " + column[2] + ", Marks: " + column[3]);
                }
            }

        }catch (IOException | CsvValidationException e){
            System.out.println(e);
        }

    }
}
