package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/


import java.io.*;

public class Solution {

    /**
     * @date 11.04.2018
     * @author Butuzov A.N.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourceAddress = reader.readLine();
        reader.close();
        try (BufferedReader readerFile =
                     new BufferedReader(
                             new FileReader(
                                     new File(fileSourceAddress)))) {
            String currentLine;
            while ((currentLine = readerFile.readLine()) != null) {
                String[] colums = currentLine.split(" ");
                if ((colums.length > 0) && colums[0].equals(args[0])) {
                    System.out.println(currentLine);
                }
            }
            readerFile.close();
        }
    }
}
