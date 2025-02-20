package com.csvdatahandling.advancedproblems.validatecsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ValidateCSV {
    public static void main(String[] args) {
        String filename = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\validatecsv\\info.csv";
         String regexEmail = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,}$";
         String regexPhone = "^[0-9]{10}$";
        try(CSVReader reader = new CSVReader(new FileReader(filename))){
            String [] column;
            while ((column=reader.readNext())!=null){
                if(!column[2].matches(regexEmail)){
                    System.out.println("Invalid Email : ");
                    System.out.println("ID: "+column[0]+" Name: "+column[1]+" Email: "+column[2]+" Phone no.: "+column[3]);
                }
                if (!column[3].matches(regexPhone)) {
                    System.out.println("Invalid Phone no. : ");
                    System.out.println("ID: "+column[0]+" Name: "+column[1]+" Email: "+column[2]+" Phone no.: "+column[3]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
