package com.csvdatahandling.advancedproblems.mergetwocsv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoCSV {
    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\mergetwocsv\\students1.csv";
        String filename2 = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\mergetwocsv\\student2.csv";
        String outputfile = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\mergetwocsv\\merged.csv";

        Map<String,String[]> data = new HashMap<>();

        try(CSVReader reader = new CSVReader(new FileReader(filename))){
             String[] column;

             while ((column=reader.readNext())!=null){
                 data.put(column[0], new String[]{column[1],column[2]});
             }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try(CSVReader reader = new CSVReader(new FileReader(filename2))){
            String[] column;

            while ((column=reader.readNext())!=null){
                if(!data.containsKey(column[0])){
                data.put(column[0], new String[]{column[1],column[2]});
            }
        }
    } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputfile))) {
            bw.write("ID,Name,Age,Marks,Grade");
            for (Map.Entry<String, String[]> entry : data.entrySet()) {
                String[] data1 = entry.getValue();
                bw.write(entry.getKey() + "," + String.join(",", data1) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("CSV files merged successfully ");
    }
        }


