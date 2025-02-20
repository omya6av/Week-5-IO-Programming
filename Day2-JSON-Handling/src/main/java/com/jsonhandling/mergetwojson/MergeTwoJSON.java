package com.jsonhandling.mergetwojson;

import org.json.JSONArray;
import org.json.JSONObject;

public class MergeTwoJSON {
    public static void main(String[] args) {

        JSONObject student1 = new JSONObject();
        JSONObject student2 = new JSONObject();

        student1.put("name", "Om");
        student1.put("age", 21);

        student2.put("name", "chaman");
        student2.put("age", 22);

        JSONArray merge = new JSONArray();

        merge.put(student1);
        merge.put(student2);

        System.out.println(merge);

    }
}
