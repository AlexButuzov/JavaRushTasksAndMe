package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import javafx.beans.binding.StringBinding;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String inputCommandLine = "";
        if (scanner.hasNext()) {
            inputCommandLine = scanner.nextLine().trim();
        }
        scanner.close();
        inputCommandLine.replace("  "," " );
        inputCommandLine.replaceAll("  "," " );

        String[] commandLineByWord = inputCommandLine.split(" ");


        if (inputCommandLine.lastIndexOf("-c") > 0) {
            String fileAddress = commandLineByWord[0];
            String lastLine = "";
            int rezult = 0;

            try (FileInputStream fileInputStream = new FileInputStream(fileAddress);
                 Scanner scanner2 = new Scanner(fileInputStream)) {
                while (scanner2.hasNextLine()) {
                    lastLine = scanner2.nextLine();
                    if (lastLine.length() > 0) {
                        int tempIndex = Integer.parseInt(lastLine.substring(0, 7).replace(" ", ""));
                        if (tempIndex > rezult) rezult = tempIndex;
                    }
                }
                scanner2.close();
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            int indexCurrentID = rezult + 1;
            String lineToFile = correctStringLength(String.valueOf(indexCurrentID), 8);
            if (commandLineByWord.length > 2) {
                String productName="";
                for (int i = 2; i < commandLineByWord.length - 2; i++) {
                    productName += commandLineByWord[i] + " ";
                }
                lineToFile += correctStringLength(productName, 30);
            } else {
                lineToFile += correctStringLength(" ", 30);
            }
            if (commandLineByWord.length > 3) {
                lineToFile += correctStringLength(commandLineByWord[commandLineByWord.length - 2], 8);

            } else {
                lineToFile += correctStringLength(" ", 8);
            }
            lineToFile += commandLineByWord[commandLineByWord.length - 1 ];
           /* if (commandLineByWord.length > 4) {
                lineToFile += correctStringLength(commandLineByWord[commandLineByWord.length - 1 ], 4);
            } else {
                lineToFile += correctStringLength(" ", 4);
            }*/
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileAddress, true)) {
                fileOutputStream.write(System.lineSeparator().getBytes());

                fileOutputStream.write(lineToFile.getBytes());
                fileOutputStream.close();
            }
        }


    }

    /*public static int findLastIndex(String fileAddress) {
        String lastLine = "";
        int rezult = 0;
        try (Scanner scanner = new Scanner(new FileInputStream(fileAddress))) {
            while (scanner.hasNext()){
                lastLine = scanner.nextLine();
                int tempIndex = Integer.parseInt(lastLine.split("[a-z,A-Z,а-я,А-Я]")[0].trim());
                if (tempIndex > rezult) rezult = tempIndex;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        return rezult;
    }*/
    public static String correctStringLength(String lineToCorrect, int lineLength) {
        String rezult = lineToCorrect;
        if (lineToCorrect.length() > lineLength) {
            rezult = lineToCorrect.substring(0, lineLength);
        } else if (lineToCorrect.length() < lineLength) {
            int coutSpaces = lineLength - lineToCorrect.length();
            for (int i = 0; i < coutSpaces; i++) {
                rezult = rezult + String.valueOf(" ");
            }
        }
        return rezult;
    }
}
