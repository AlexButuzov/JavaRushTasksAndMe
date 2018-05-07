package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

    /**
     * @date 04.04.2018
     *
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourceAddress = reader.readLine();
        reader.close();

        int counter = 0;
        FileInputStream inputStream = new FileInputStream(fileSourceAddress);
        while (inputStream.available() > 0) {
            int currentFileByte = inputStream.read();
            if (',' == currentFileByte) {
                counter++;
            }
        }
        inputStream.close();
        System.out.println(counter);
    }
}
