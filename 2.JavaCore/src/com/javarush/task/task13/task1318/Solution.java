package com.javarush.task.task13.task1318;


import java.io.*;
import java.util.Scanner;



/*
Чтение файла
*/

public class Solution {

    private static String addressInputFile = "";

    /**
     * 12.03.2018
     *
     * @param args
     */
    public static void main(String[] args) {
        // напишите тут ваш код
        try {
            readFileAddress();
            transleteFileIntoScreen();
        } catch (IOException expept) {
            System.out.println(expept);
        }
    }

    private static void readFileAddress() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Solution.addressInputFile = reader.readLine();
        reader.close();
    }

    static void transleteFileIntoScreen() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(addressInputFile);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}