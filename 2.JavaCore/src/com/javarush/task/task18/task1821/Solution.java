package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args)   {
        String   fileAddress = args[0];
        try (FileInputStream fileInputStream = new FileInputStream(fileAddress);) {

            TreeMap<Character, Integer> charFrequency = new TreeMap<Character, Integer>();

            while (fileInputStream.available() > 0) {
                int sizeBuffer = 64000;
                if (fileInputStream.available() < sizeBuffer) sizeBuffer = fileInputStream.available();
                byte[] charBuffer = new byte[sizeBuffer];
                fileInputStream.read(charBuffer);
                char[] c = new String(charBuffer).toCharArray();
                Arrays.sort(c);
                for (int i = 0; i < c.length; i++) {
                    if (charFrequency.containsKey(c[i])) {
                        int newValue = charFrequency.get(c[i]) + 1;
                        charFrequency.put(c[i], newValue);
                    } else {
                        charFrequency.put(c[i], 1);
                    }
                }
            }
            for (Map.Entry<Character, Integer> pair : charFrequency.entrySet()) {
                System.out.println(pair.getKey() + " " + pair.getValue());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
