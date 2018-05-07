package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {

    /**
     * @date 18.04.2018
     * @author Butuzov A.N.
     * @param args [0] SourceFile [1] FileDestenation
     * @throws IOException if FileNotFound or operatin .close() can't be done
     */
    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            FileReader fileReader = new FileReader(args[0]);
            BufferedReader reader = new BufferedReader(fileReader);

            String lineToFile = "";
            while (reader.ready()) {
                String[] linneByWordFromFile = reader.readLine().trim().split(" ");

                for (int i = 0; i < linneByWordFromFile.length; i++) {
                    String currentWord = linneByWordFromFile[i];

                    if (! currentWord.equals(currentWord.replaceAll("[0-9]",""))) {
                        if (lineToFile.length() > 0) lineToFile += String.valueOf(" ");
                        lineToFile += String.valueOf(currentWord);
                    }

                }
            }
            reader.close();
            fileReader.close();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
            bufferedWriter.write(lineToFile);
            bufferedWriter.close();



        }
    }
}
