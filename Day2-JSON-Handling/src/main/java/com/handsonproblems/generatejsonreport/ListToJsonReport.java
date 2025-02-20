package com.json.handsonproblems.generatejsonreport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.handsonproblems.csvtojson.Employee;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
public class ListToJsonReport {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Naman", "naman@example.com", 21));
        employees.add(new Employee(2, "Om", "om@example.com", 22));
        employees.add(new Employee(3, "Ishan", "ishan@example.com", 23));


        String jsonFilePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day2\\src\\main\\java\\com\\json\\handsonproblems\\generatejsonreport\\employees_report.json";

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode arrayNode = objectMapper.createArrayNode();


            for (Employee emp : employees) {
                ObjectNode record = objectMapper.createObjectNode();
                record.put("id", emp.getId());
                record.put("name", emp.getName());
                record.put("email", emp.getEmail());
                record.put("age", emp.getAge());
                arrayNode.add(record);
            }


            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), arrayNode);

            System.out.println("JSON Report Generated Successfully: " + jsonFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}