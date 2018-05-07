package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/



import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    private static String fileName = "";
    private static ArrayList<Integer> evenNumbersFromFile = new ArrayList<Integer>();

    /**
     * 13.03.2018
     * @param args
     */
    public static void main(String[] args) {
        // напишите тут ваш код
        readFileName();
        readNumbersFromFile();
        sortNumbers();
        printNumbers();
    }

    /**
     * 13.03.2018
     * @param
     */
    private static void readFileName(){
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
            fileName = reader.readLine();
            reader.close();
        } catch (IOException exp) {
            System.out.println("не корректный ввод строки" + exp);
        }

    }

    /**
     * 13.03.2018
     * @param
     */
    private static void readNumbersFromFile() {
        File flle = new File(fileName);

        try {

            BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(fileName)));
            String lineFromFile = reader.readLine();

            while (lineFromFile != null)
            {
                int data = Integer.parseInt(lineFromFile);
                if((data%2) == 0) {
                    evenNumbersFromFile.add(data);
                }
                lineFromFile = reader.readLine();
            }
            reader.close();

        } catch (IOException exp) {
            System.out.println("Error read data from file :" + exp);
        }
    }

    /**
     * 13.03.2018
     * @param
     */
    private static void sortNumbers() {

        Collections.sort(evenNumbersFromFile);
    }

    /**
     * 13.03.2018
     * @param
     */
    private static void printNumbers() {

        int sizeEvenNumbersFromFile = evenNumbersFromFile.size();
        for (int i = 0; i < sizeEvenNumbersFromFile; i++) {
            System.out.println(evenNumbersFromFile.get(i));
        }
        evenNumbersFromFile.clear();
    }

}
