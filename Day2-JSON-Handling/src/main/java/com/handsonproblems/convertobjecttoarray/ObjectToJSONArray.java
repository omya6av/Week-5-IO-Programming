package com.handsonproblems.convertobjecttoarray;

import org.json.JSONArray;
import org.json.JSONObject;

public class ObjectToJSONArray {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        JSONObject student2 = new JSONObject();
        JSONObject student3 = new JSONObject();
        student.put("Name","Naman");
        student2.put("Name","Ishan");
        student3.put("Name","Om");
        JSONArray students = new JSONArray();
        students.put(student);
        students.put(student2);
        students.put(student3);

        System.out.println(students);
    }
}
