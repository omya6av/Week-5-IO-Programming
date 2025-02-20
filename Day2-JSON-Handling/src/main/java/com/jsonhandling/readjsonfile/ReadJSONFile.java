package com.jsonhandling.readjsonfile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import javax.xml.namespace.QName;
import java.io.File;
import java.io.IOException;

public class ReadJSONFile {
    public static void main(String[] args) {

        try {
            File filePath = new File("C:\\\\Users\\\\91989\\\\Desktop\\\\Week-5-IO-Programming\\\\Day2-JSON-Handling\\\\src\\\\main\\\\java\\\\jsonhandling\\\\readjsonfile\\\\Student.json");
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(filePath);

            String name = jsonNode.get("name").asText();
            String email = jsonNode.get("email").asText();
            System.out.println("User Name : " + name);
            System.out.println("User email : " + email);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
