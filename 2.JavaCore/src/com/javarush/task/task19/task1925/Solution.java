package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length > 0){
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
            String outputLine = "";
            while (reader.ready()){

                String[] lineFromFile = reader.readLine().split(" ");
                for (int i = 0; i < lineFromFile.length; i++) {
                    if (lineFromFile[i].length() > 6) {
                        if (outputLine.length() >0 ) outputLine += String.valueOf(",");
                        outputLine += String.valueOf(lineFromFile[i]);
                    }
                }

            }
            writer.write(outputLine);
            reader.close();
            writer.close();
        }

    }
}
