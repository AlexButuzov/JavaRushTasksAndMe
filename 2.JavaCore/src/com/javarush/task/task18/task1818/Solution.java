package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader ( System.in  ));
        String fileDestenation = reader.readLine();
        String fileSourceOne = reader.readLine();
        String fileSourceTwo = reader.readLine();
        reader.close();

        FileWriter fileWriter = new FileWriter(fileDestenation);
        FileReader fileReader = new FileReader(fileSourceOne);
        while (fileReader.ready()) {
            char[] buffer = new char[64000];
            int sizeBuffer = fileReader.read(buffer);
            for (int i = 0; i < sizeBuffer ; i++) {fileWriter.write(buffer[i]);
            }

        }

        fileReader.close();
        FileReader fileReader1 = new FileReader(fileSourceTwo);
        while (fileReader1.ready()) {
            char[] buffer = new char[64000];
            int sizeBuffer = fileReader1.read(buffer);
            for (int i = 0; i < sizeBuffer ; i++) {fileWriter.write(buffer[i]);
            }
        }

        fileReader1.close();
        fileWriter.close();

    }
}
