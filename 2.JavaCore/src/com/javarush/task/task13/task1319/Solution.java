package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    private static  String fileName = "";

    public static void main(String[] args) {
        // напишите тут ваш код
        readFileName();

        writeConsolToFile();

    }

    private static void readFileName() {
        BufferedReader reader = null;
        reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            Solution.fileName = reader.readLine();
            reader.close();
        } catch (IOException exp) {
            System.out.println(exp);
        }
    }

    private static void writeConsolToFile() {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));

        BufferedWriter fileWriter = null;
        //File destenaionFile = new File();
        //////////

        String inputLine = "";
        try {
            OutputStream outStream = new FileOutputStream(Solution.fileName);
            fileWriter = new BufferedWriter( new OutputStreamWriter( outStream));

            inputLine = reader.readLine();
            while (!"exit".equals(inputLine)) {
                fileWriter.write(inputLine);
                fileWriter.newLine();
                inputLine = reader.readLine();
            }
            fileWriter.write(inputLine);

            reader.close();
            fileWriter.close();

        } catch (IOException exp) {
            exp.printStackTrace();
        }



    }
}
