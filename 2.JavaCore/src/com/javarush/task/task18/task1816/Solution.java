package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Solution {

    /**
     * @date 06.04.2018
     * @author Butuzov A.N.
     */
    public static void main(String[] args) throws Exception, FileNotFoundException{
        if (args[0] != null) {
            FileReader fileReader = new FileReader(args[0]);
            int count = 0;
            while (fileReader.ready()) {
                char[] buffer = new char[64000];
                int sizeBuffer = fileReader.read(buffer);

                for (int i = 0; i < sizeBuffer ; i++) {
                    char a = buffer[i];
                        if((a>='a'&a<='z')||(a>='A'&a<='Z')) {
                            count++;
                        }
                }
            }
            fileReader.close();
            System.out.println(count);
        }


    }
}
