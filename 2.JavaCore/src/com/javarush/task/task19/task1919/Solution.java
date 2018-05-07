package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> stringDoubleMap = new TreeMap<String, Double>();

        while (reader.ready()) {
            String[] lineByWord = reader.readLine().trim().split(" ");
            String name = lineByWord[0];
            double value = 0;
            try {
                value = Double.parseDouble(lineByWord[1]);
            } catch (Exception exp) {
            }
            if (stringDoubleMap.containsKey(name)) {
                value += stringDoubleMap.get(name);
            }
            stringDoubleMap.put(name, value);
        }
        reader.close();

        for (Map.Entry<String, Double> pair : stringDoubleMap.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

    }
}
