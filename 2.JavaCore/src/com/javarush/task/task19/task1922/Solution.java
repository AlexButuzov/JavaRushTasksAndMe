package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    /**
     * @date 18.04.2018
     * @author Butuzov A.N.
     * @throws IOException if FileNotFound or operatin .close() can't be done
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourseFileAddress = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(sourseFileAddress));
        while (bufferedReader.ready()) {
            String lineFromFile = bufferedReader.readLine();
            String[] lineByWord = lineFromFile.trim().split(" ");
            if (lineByWord.length > 0) {
                int counter = 0;
                for (int i = 0; i < lineByWord.length; i++) {
                    for (int j = 0; j < words.size(); j++) {
                        if (lineByWord[i].equals(words.get(j))) counter++;
                    }
                }
                if (counter == 2) System.out.println(lineFromFile);
            }
        }
        bufferedReader.close();
    }
}
