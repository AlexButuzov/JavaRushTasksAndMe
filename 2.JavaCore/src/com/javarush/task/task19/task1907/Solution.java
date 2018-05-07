package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));

        String fileSouresAddress = bufferedReader.readLine();
        bufferedReader.close();

        FileReader fileReader = new FileReader(fileSouresAddress);
        BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
        int counter = 0 ;
        while(bufferedReaderFile.ready()) {
            String currentLine = bufferedReaderFile.readLine();
            if ("world".equals(currentLine)) {
                counter++;
            } else {
                counter += currentLine.split("world").length - 1;
            }
        }
        bufferedReaderFile.close();
        fileReader.close();
        System.out.println(counter);

    }
}
