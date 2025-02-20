package com.jsonhandling.filterjson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class FilterJSON {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day2-JSON-Handling\\src\\main\\java\\jsonhandling\\filterjson\\students.json");
            JsonNode jsonNode = objectMapper.readTree(file);
            for (JsonNode node : jsonNode) {
                if (node.has("age") && node.get("age").asInt() > 25) {
                    System.out.println(node);
                }


        } }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
