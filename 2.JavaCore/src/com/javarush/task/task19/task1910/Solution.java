package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourceAddress = reader.readLine();
        String fileDestenationAddress = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileSourceAddress));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileDestenationAddress));
        while (bufferedReader.ready()) {
            String currentLine = bufferedReader.readLine();

            String rezultLine = currentLine.replaceAll("[^ a-zA-Zа-яА-Я0-9]" , "");
            bufferedWriter.write(rezultLine);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
