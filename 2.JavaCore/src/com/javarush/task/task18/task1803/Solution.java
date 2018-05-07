package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileAddress = reader.readLine();
        reader.close();

        Long[] arrBytes = new Long[256];
        int bufferSize = 64000;  //задаем буфер чтения
        byte buffer[] = new byte[64000];

        Long maxByteFrequency;

       FileInputStream fileSourseStream = new FileInputStream(fileAddress);

            while (fileSourseStream.available() > 0) {

                int read = fileSourseStream.read();
                //System.out.println(arrBytes[read] + " Значение");

                   // arrButes[128+buffer[0]]++;  // добавляем 128 для не отрицательного значения индекса массива счетчиков
                if (arrBytes[read] != null){
                arrBytes[read] = arrBytes[read]+ (long)1;
                } else {
                    arrBytes[read] = (long) 1;
                }

                //System.out.println(read);

            }
            fileSourseStream.close();
        Long arrByteFrequency[] = new Long [256];
        Arrays.sort(arrByteFrequency);


        //ищем максимальную частоту
        maxByteFrequency = (long) 0;
        for (int i = 0; i < arrBytes.length; i++) {
            if (arrBytes[i] != null) {
                if (maxByteFrequency < arrBytes[i]) maxByteFrequency = arrBytes[i];
            }
        }
        //выводим элементы с максимальной частотой
        for (int i = 0; i < arrBytes.length; i++) {
            if (maxByteFrequency == arrBytes[i])
                System.out.printf(i + " "); // преобразуем индекс массива в байты и выводим
        }
        System.out.println();


    }
}
