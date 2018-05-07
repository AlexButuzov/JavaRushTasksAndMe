package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String sourceFileAddress = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(sourceFileAddress));
        while (reader1.ready()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(reader1.readLine());
            stringBuffer.reverse();
            System.out.println(stringBuffer.toString());
        }
        reader1.close();
    }
}
