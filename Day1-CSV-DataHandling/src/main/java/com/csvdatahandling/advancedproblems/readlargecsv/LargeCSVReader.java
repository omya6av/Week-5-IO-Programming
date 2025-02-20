package com.csvdatahandling.advancedproblems.readlargecsv;

import java.io.*;

public class LargeCSVReader {
    public static void readCSVInChunks(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                count++;

                if (count % chunkSize == 0) {
                    batchCount++;
                    System.out.println("Processed " + count + " records so far (Batch: " + batchCount + ")");
                }
            }

            System.out.println("Total records processed: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\readlargecsv\\large_file.csv";
        int chunkSize = 100;
        readCSVInChunks(filePath, chunkSize);
    }
}
