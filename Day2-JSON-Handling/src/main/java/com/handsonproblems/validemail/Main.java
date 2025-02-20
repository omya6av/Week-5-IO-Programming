package com.handsonproblems.validemail;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        // Load JSON from a file (sample.json)
        String jsonFilePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day2\\src\\main\\java\\com\\json\\handsonproblems\\validemail\\sample.json";

        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get(jsonFilePath)));

            // Parse JSON to User object
            ObjectMapper objectMapper = new ObjectMapper();
            User user = objectMapper.readValue(jsonContent, User.class);

            // Validate user email
            EmailValidator.validateUser(user);
        } catch (Exception e) {
            System.out.println(" Error processing JSON: " + e.getMessage());
        }
    }
}
