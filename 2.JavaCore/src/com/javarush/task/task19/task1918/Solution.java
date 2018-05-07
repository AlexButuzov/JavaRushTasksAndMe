package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static String openTag = "";
    private static String closeTag = "";
    private static  StringBuffer fileSource;
    public static void main(String[] args) throws IOException {
        openTag = "<" + args[0];
        closeTag = "</" + args[0].trim().split(" ")[0] + ">";

        BufferedReader readerFileAddress = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileAddress = readerFileAddress.readLine();
        readerFileAddress.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(sourceFileAddress));
         fileSource = new StringBuffer();
        while (fileReader.ready()) {
            fileSource.append(fileReader.readLine());
        }
        fileReader.close();
        int length = fileSource.length();
        int indexStartFinder = fileSource.indexOf(openTag, 0);           //начало блока
        int indexOfCloseTag = 0;
        while (indexStartFinder > 0 | indexOfCloseTag == 0) {
            indexOfCloseTag = findCloseTag(indexStartFinder);
            System.out.println(fileSource.substring(indexStartFinder, indexOfCloseTag));
            indexStartFinder = fileSource.indexOf(openTag,
                    indexStartFinder + 1 );
        }
    }

    private static int findCloseTag(int indexStartFinder) {
        int rezult = 0;
        int indexNextOpenTag = fileSource.indexOf(openTag,indexStartFinder+1);
        int indexNextCloseTag =  fileSource.indexOf(closeTag, indexStartFinder +1);
        if ( (indexNextOpenTag > indexNextCloseTag)
                | (indexNextOpenTag == -1)) {
            rezult = indexNextCloseTag + closeTag.length();
        } else {
            rezult = findCloseTag(indexNextCloseTag);
        }
        return rezult;
    }
}
