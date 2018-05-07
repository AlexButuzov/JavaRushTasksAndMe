package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {

    /**
     * @date 09.04.2018
     * @author Butuzov A.N.
     */
    public static void main(String[] args) throws Exception, FileNotFoundException {
        if (args[0] != null) {
            FileReader fileReader = new FileReader(args[0]);
            long countAll = 0;
            long countSpace = 0;
            while (fileReader.ready()) {
                char[] buffer = new char[64000];
                int sizeBuffer = fileReader.read(buffer);

                for (int i = 0; i < sizeBuffer ; i++) {
                    char currentChar = buffer[i];
                    countAll++;
                    if (currentChar == ' ') {
                        countSpace++;
                    }
                }
            }
            fileReader.close();
            double rezultPersent = (countSpace * 1.) / (1. * countAll) * 100;
            System.out.println(
                    new BigDecimal(rezultPersent).setScale(2, RoundingMode.HALF_UP).doubleValue());
        }


    }

}
