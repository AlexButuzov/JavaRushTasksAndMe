package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String fileSourceAddress = reader.readLine();
        String fileDestenationAddress = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileSourceAddress));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileDestenationAddress));

        while (bufferedReader.ready()){
            String currentLine = bufferedReader.readLine();
            String[] currentLinePerWord = currentLine.trim().split(" ");
            boolean firestAdded = false;
            for (int i = 0; i < currentLinePerWord.length; i++) {
                String currenWord = currentLinePerWord[i];

                try {
                    int nuber=Integer.parseInt(currenWord);

                    bufferedWriter.write(" " + nuber);
                } catch (Exception exp)
                {}
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
