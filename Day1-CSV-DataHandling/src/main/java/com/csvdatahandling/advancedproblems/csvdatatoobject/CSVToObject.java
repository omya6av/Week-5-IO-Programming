package com.csvdatahandling.advancedproblems.csvdatatoobject;


import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVToObject {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\csvdatatoobject\\students.csv";
        List<Student> studentList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = reader.readAll();

            for (int i = 1; i < records.size(); i++) {
                String[] row = records.get(i);
                String name = row[0];
                int age = Integer.parseInt(row[1]);
                String course = row[2];
                double marks = Double.parseDouble(row[3]);

                Student student = new Student(name, age, course, marks);
                studentList.add(student);
            }

            System.out.println("List of Students:");
            for (Student student : studentList) {
                System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}