package com.handsonproblems.readjsonfileandprint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadJsonFile {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day2-JSON-Handling\\src\\main\\java\\com\\handsonproblems\\readjsonfileandprint\\students.json"));
              for(JsonNode node : jsonNode){
                  System.out.println(node);
              }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
