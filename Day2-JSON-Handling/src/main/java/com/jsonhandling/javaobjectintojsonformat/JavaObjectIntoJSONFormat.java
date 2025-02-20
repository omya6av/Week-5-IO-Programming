package com.jsonhandling.javaobjectintojsonformat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaObjectIntoJSONFormat {
    public static void main(String[] args) {

   try{
       Car maruti = new Car(140, "Black", 1550000, "Grand Vitara" );

       ObjectMapper objectMapper = new ObjectMapper();
       String jsonString = objectMapper.writeValueAsString(maruti);
       System.out.println(jsonString);


   } catch (JsonProcessingException e) {
       throw new RuntimeException(e);
   }


    }
}
