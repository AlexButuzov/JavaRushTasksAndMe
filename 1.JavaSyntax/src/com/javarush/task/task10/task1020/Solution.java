package com.javarush.task.task10.task1020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[30];
        for (int i = 0; i < 30; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.println(array[9]);
        System.out.println(array[10]);
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrList.add(array[i]);
        }

        Collections.sort(arrList);

        Integer[] newArray = arrList.toArray(new Integer[arrList.size()] );
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }
}