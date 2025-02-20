package com.csvdatahandling.advancedproblems.detectduplicate;

import java.io.*;
import java.util.*;

public class DuplicateCSVDetector {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\detectduplicate\\students.csv";
        detectDuplicates(filePath);
    }

    public static void detectDuplicates(String filePath) {
        Map<String, List<String>> recordsMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine(); // Read the header line
            System.out.println("Header: " + header);

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0].trim(); // Assuming ID is the first column

                recordsMap.putIfAbsent(id, new ArrayList<>());
                recordsMap.get(id).add(line);
            }

            System.out.println("Duplicate Records:");
            for (Map.Entry<String, List<String>> entry : recordsMap.entrySet()) {
                if (entry.getValue().size() > 1) {
                    for (String record : entry.getValue()) {
                        System.out.println(record);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

