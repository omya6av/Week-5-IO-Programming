package com.csvdatahandling.advancedproblems.csvtojson;

import java.io.*;
import java.util.*;
import org.json.*;

public class JSONCSVConverter {
    public static void main(String[] args) {
        String jsonFilePath = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\csvtojson\\students.json";
        String csvFilePath = "C:\\Users\\91989\\Desktop\\Week-5-IO-Programming\\Day1-CSV-DataHandling\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\csvtojson\\students.csv";

        convertJsonToCsv(jsonFilePath, csvFilePath);
        convertCsvToJson(csvFilePath, "output.json");
    }

    public static void convertJsonToCsv(String jsonFilePath, String csvFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(csvFilePath))) {

            StringBuilder jsonString = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray studentsArray = new JSONArray(jsonString.toString());
            if (studentsArray.length() > 0) {
                JSONObject firstObj = studentsArray.getJSONObject(0);
                Set<String> keys = firstObj.keySet();

                bw.write(String.join(",", keys));
                bw.newLine();

                for (int i = 0; i < studentsArray.length(); i++) {
                    JSONObject obj = studentsArray.getJSONObject(i);
                    List<String> values = new ArrayList<>();
                    for (String key : keys) {
                        values.add(obj.optString(key, ""));
                    }
                    bw.write(String.join(",", values));
                    bw.newLine();
                }
            }

            System.out.println("JSON converted to CSV successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public static void convertCsvToJson(String csvFilePath, String jsonOutputPath) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(jsonOutputPath))) {

            String headerLine = br.readLine();
            if (headerLine == null) return;

            String[] headers = headerLine.split(",");
            JSONArray jsonArray = new JSONArray();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject jsonObject = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values.length > i ? values[i] : "");
                }
                jsonArray.put(jsonObject);
            }

            bw.write(jsonArray.toString(4));
            System.out.println("CSV converted to JSON successfully.");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
