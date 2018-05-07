package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileAddress = reader.readLine();
        reader.close();

        BufferedReader fileBuffer = new BufferedReader(new FileReader(sourceFileAddress));
        while (fileBuffer.ready()) {
            String[] lineFromFile = fileBuffer.readLine().trim().split(" ");
            String stringBuffer = "";
            for (int i = 0; i < lineFromFile.length; i++) {
                if (i > 0) stringBuffer += String.valueOf(" ");
                try {
                    int number = Integer.parseInt(lineFromFile[i]);
                    if (map.containsKey(number)) {
                        stringBuffer += String.valueOf(map.get(number));
                    } else stringBuffer += String.valueOf(lineFromFile[i]);
                } catch (Exception ex) {
                    stringBuffer += String.valueOf(lineFromFile[i]);
                }
            }
            System.out.println(stringBuffer);
        }

        fileBuffer.close();
    }
}
