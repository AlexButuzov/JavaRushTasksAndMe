package com.javarush.task.task18.task1804;

import java.io.*;
import java.util.Arrays;

/* 
Самые редкие байты
*/

public class Solution {

    /**
     * 03.04.2018
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileSourceAddress = reader.readLine();
        reader.close();

        Long[] arrByteFrequency;
        long firstFrequency;
        FileInputStream fileSourseStr = new FileInputStream(fileSourceAddress);
        arrByteFrequency = new Long[256];
        while (fileSourseStr.available() > 0) {
            int currentByte = fileSourseStr.read();
            if (arrByteFrequency[currentByte] != null) {
                arrByteFrequency[currentByte]++;
            } else {
                arrByteFrequency[currentByte] = (long) 1;
            }
        }
        fileSourseStr.close();
        for (int i = 0; i < arrByteFrequency.length; i++) {
            if (arrByteFrequency[i] == null) arrByteFrequency[i] = (long) 0;
        }

        Arrays.sort(arrByteFrequency);
        firstFrequency = (long) 0;
        for (int i = 0; i < arrByteFrequency.length; i++) {
            if (arrByteFrequency[i] != 0) {
                if (firstFrequency == 0) {
                    firstFrequency = arrByteFrequency[i];
                } else if (firstFrequency == arrByteFrequency[i]) {
                    System.out.print((i - 128) + " ");
                } else break;
            }
        }

        System.out.println();


    }
}
