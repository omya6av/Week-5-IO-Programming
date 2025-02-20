package com.csvdatahandling.advancedproblems.encrytanddecrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }

    public static void writeEncryptedCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                row[2] = encrypt(row[2]); // Encrypt Salary
                row[3] = encrypt(row[3]); // Encrypt Email
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Encrypted CSV written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readDecryptedCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                row[2] = decrypt(row[2]); // Decrypt Salary
                row[3] = decrypt(row[3]); // Decrypt Email
                System.out.println(String.join(",", row));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\naman\\OneDrive\\Desktop\\Week-05---IO-Programming\\Day1\\src\\main\\java\\com\\csvdatahandling\\advancedproblems\\encrytanddecrypt\\employees.csv";
        List<String[]> data = Arrays.asList(
                new String[]{"ID", "Name", "Salary", "Email"},
                new String[]{"1", "Naman", "50000", "naman@gmaul.com"},
                new String[]{"2", "Ishan", "60000", "ishan@gmail.com"}
        );

        writeEncryptedCSV(filePath, data);
        System.out.println("Decrypted Data:");
        readDecryptedCSV(filePath);
    }
}
