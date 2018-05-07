package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileDestenation = reader.readLine();
        String fileSource = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(fileDestenation);
        byte[] bufferOne =  new byte[fileReader.available()];
         fileReader.read(bufferOne);
        fileReader.close();

        FileInputStream fileReaderTwo = new FileInputStream(fileSource);

        byte[] bufferTwo = new byte[fileReaderTwo.available()];
        fileReaderTwo.read(bufferTwo);
        fileReaderTwo.close();

        FileOutputStream fileOutputStream = new FileOutputStream(fileDestenation);

        fileOutputStream.write(bufferTwo);
        fileOutputStream.close();
        fileOutputStream = new FileOutputStream(fileDestenation, true);
        fileOutputStream.write(bufferOne);
        fileOutputStream.close();

    }
}
