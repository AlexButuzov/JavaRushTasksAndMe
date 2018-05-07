package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Boolean run = true;
        String fileAddress = "";
        while (run) {
            try {
                fileAddress = reader.readLine();
                FileInputStream fileInputStream = new FileInputStream( new File(fileAddress));
                fileInputStream.close();
            } catch (FileNotFoundException exp) {
                run = false;
                System.out.println(fileAddress);
            }

        }
    }
}
