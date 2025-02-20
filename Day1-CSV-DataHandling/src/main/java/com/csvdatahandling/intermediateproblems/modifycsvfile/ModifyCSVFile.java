package com.csvdatahandling.intermediateproblems.modifycsvfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyCSVFile {
    public static void main(String[] args) {

        String fileName = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\modifycsvfile\\employee.csv";
        String outputFile = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\src\\main\\java\\com\\csvdatahandling\\intermediateproblems\\modifycsvfile\\updatedemployee.csv";

        String target = "IT";

        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
                String[] column;

                while ((column = reader.readNext()) != null) {
                    if (column[2].equals(target)) {
                        double salary = Double.parseDouble(column[3]);
                        salary = (salary * 10 / 100) + salary;
                        column[3] = String.valueOf(salary);
                    }

                    writer.writeNext(column);


                }

            } catch (IOException e) {
                System.out.println(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

