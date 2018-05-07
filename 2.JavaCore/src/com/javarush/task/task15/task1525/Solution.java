package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            BufferedReader reader = new BufferedReader( new FileReader(String.valueOf(Statics.FILE_NAME)));

            lines = reader.lines().collect(Collectors.toList());
            try {
                reader.close();
            } catch (IOException exp){
                System.out.println(exp.getStackTrace());
            }

        } catch (FileNotFoundException  ext) {
            System.out.println(ext.getStackTrace());
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
