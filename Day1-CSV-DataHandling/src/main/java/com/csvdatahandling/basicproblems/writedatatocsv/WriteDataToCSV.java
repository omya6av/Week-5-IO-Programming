package com.csvdatahandling.basicproblems.writedatatocsv;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToCSV {
        public static void main(String[] args) throws IOException {

            String fileName = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\employdetail.csv";

            try(CSVWriter writer = new CSVWriter(new FileWriter(fileName))){
                String[] header = {"ID", "Name", "Department", "Salary"};
                String[] emp1 = {"98", "Om yadav", "Data analyst", "62000"};
                String[] emp2 = {"54", "harash", "finance", "58000"};

                writer.writeNext(header);
                writer.writeNext(emp1);
                writer.writeNext(emp2);

                System.out.println("CSV file written successfully using OpenCSV");

            }catch (IOException e){
                System.out.println(e);
            }
        }
    }