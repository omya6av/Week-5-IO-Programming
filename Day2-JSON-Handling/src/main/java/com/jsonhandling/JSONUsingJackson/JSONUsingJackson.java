package com.jsonhandling.JSONUsingJackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class JSONUsingJackson {
    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File filePath = new File( "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day2-JSON-Handling\\src\\main\\java\\jsonhandling\\JSONUsingJackson\\Student.json");

            JsonNode jsonNode = objectMapper.readTree(filePath);

            if(jsonNode.has("id") && jsonNode.has("name") && jsonNode.has("email")){
                System.out.println("Valid json file. ");
            }else{
                System.out.println("Invalid json file. ");
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
