package com.handsonproblems.csvtojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFilePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day2\\src\\main\\java\\com\\json\\handsonproblems\\csvtojson\\students.csv";
        try {

            FileReader reader = new FileReader(csvFilePath);
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<com.json.handsonproblems.csvtojson.Employee>(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Employee> employees = csvToBean.parse();


            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(employees);

            System.out.println("Converted JSON:");
            System.out.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
