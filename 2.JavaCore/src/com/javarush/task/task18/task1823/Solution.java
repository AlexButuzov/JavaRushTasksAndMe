package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws InterruptedException {
        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(System.in))) {
            String fileAddress;
            while (!"exit".equals(fileAddress = reader.readLine())) {
                ReadThread currentThread = new ReadThread(fileAddress);
                currentThread.start();
                currentThread.join();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ReadThread extends Thread {
        private String fileAddress;

        public ReadThread(String fileName) {
            //implement constructor body
            fileAddress = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        public void run() {

            try (FileInputStream fileInputStream =
                         new FileInputStream(
                                 new File(fileAddress))) {
                Long[] byteFrequency = new Long[256];
                HashMap<Byte,Long> byteLongHashMap = new HashMap<Byte,Long>();
                while (fileInputStream.available() > 0) {
                    int sizeBuffer = 64000;
                    if (fileInputStream.available() < sizeBuffer) sizeBuffer = fileInputStream.available();
                    byte[] byteBuffer = new byte[sizeBuffer];
                    fileInputStream.read(byteBuffer);
                    for (int i = 0; i < byteBuffer.length; i++) {
                       if (byteLongHashMap.containsKey(byteBuffer[i])) {
                           Long newValue = byteLongHashMap.get(byteBuffer[i]) + 1L;
                           byteLongHashMap.put(byteBuffer[i], newValue);
                       } else {
                           byteLongHashMap.put(byteBuffer[i], 1L);
                       }
                    }
                }
                fileInputStream.close();
                Integer max = (int) Collections.max(byteLongHashMap.entrySet(), Map.Entry.comparingByValue()).getKey();
                resultMap.put(fileAddress, max);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
