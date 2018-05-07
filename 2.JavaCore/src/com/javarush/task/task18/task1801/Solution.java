package com.javarush.task.task18.task1801;

import java.io.*;



/* 
Максимальный байт
*/

public class Solution {
    
    /**02.04.2018
    */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileAddress = reader.readLine();
        reader.close();

        
        FileInputStream fileStream = new FileInputStream(fileAddress);
        int maxByte = 0 ;
        while ( fileStream.available() > 0) {
            int currentByte = fileStream.read();
            if ( currentByte > maxByte) maxByte = currentByte;
        }
        fileStream.close();
        System.out.println(maxByte);
    }
}
