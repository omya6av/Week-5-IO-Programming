package com.csvdatahandling.advancedproblems.csvreport;
import java.io.*;
import java.util.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\csvreport\\employees.csv";

        List<String[]> employeeData = Arrays.asList(
                new String[]{"EmployeeID", "Name", "Department", "Salary"},
                new String[]{"1", "Naman", "HR", "50000"},
                new String[]{"2", "Ishan", "IT", "60000"},
                new String[]{"3", "Om", "Finance", "70000"}
        );

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            for (String[] row : employeeData) {
                writer.write(String.join(",", row));
                writer.newLine();
            }

            System.out.println("CSV file generated successfully: " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
