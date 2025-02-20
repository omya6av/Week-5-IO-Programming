package com.iplcensoranalyzer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.csv.*;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        String inputFile = "ipl_data.csv";
        String outputFile = "ipl_data_censored.csv";

        processCSV(inputFile, outputFile);
    }

    public static void processCSV(String inputFile, String outputFile) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(inputFile));
                Writer writer = Files.newBufferedWriter(Paths.get(outputFile));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .setIgnoreSurroundingSpaces(true)
                        .setTrim(true)
                        .build());
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("match_id", "team1", "team2", "score_team1", "score_team2", "winner", "player_of_match"))
        ) {
            List<CSVRecord> records = csvParser.getRecords();

            for (CSVRecord record : records) {
                csvPrinter.printRecord(
                        record.get("match_id"),
                        censorTeamName(record.get("team1")),
                        censorTeamName(record.get("team2")),
                        record.get("score_team1"),
                        record.get("score_team2"),
                        censorTeamName(record.get("winner")),
                        "REDACTED"
                );
            }

            System.out.println("Censored CSV data saved to: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String censorTeamName(String teamName) {
        if (teamName == null || teamName.trim().isEmpty()) {
            return teamName; // Avoid modifying empty/null team names
        }
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "*";
        }
        return String.join(" ", words);
    }
}