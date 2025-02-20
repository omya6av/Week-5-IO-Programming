package com.jsonhandling.createjsonbject;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObject {

    public static void main(String[] args) {

        JSONArray student = new JSONArray();

        student.put( "Omi");
        student.put( 21);
        student.put( "Maths");
        student.put( "Physics");
        student.put( "Chemistry");

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("student", student);

        System.out.println(jsonObject);
    }
}
