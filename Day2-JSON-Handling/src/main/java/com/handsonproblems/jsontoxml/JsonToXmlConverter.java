package com.handsonproblems.jsontoxml;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXmlConverter {
    public static void main(String[] args) {

        String jsonString = """
        {
            "person": {
                "name": "NAman",
                "age": 21,
                "address": {
                    "city": "Bhopal",
                    "zip": "462022"
                },
              
            }
        }
        """;


        JSONObject jsonObject = new JSONObject(jsonString);
        String xml = XML.toString(jsonObject, "root");


        System.out.println(xml);
    }
}
