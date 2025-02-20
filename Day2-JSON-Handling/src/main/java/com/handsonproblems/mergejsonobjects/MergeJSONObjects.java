package com.json.practiceproblems.mergejsonobjects;

import org.json.JSONObject;

public class MergeJSONObjects {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        JSONObject student2 = new JSONObject();
        student.put("Name","Naman");
        student.put("Age",21);
        student2.put("Name","Ishan");
        student2.put("Age",22);

        for(String key : student2.keySet()){
            student.put(key,student2.get(key));

            System.out.println(student.toString());
        }
    }
}
