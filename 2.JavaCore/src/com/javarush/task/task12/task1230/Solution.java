package com.javarush.task.task12.task1230;

/* 
Попадание в десятку
*/

public class Solution {
    public static void main(String[] args) {
        Integer i = 5;
        int x = transformValue(i);

        System.out.println(x);
    }

    /**
     *06.03.2018
     */
    public static int transformValue (Integer count) { return count + count; }

    public static int transformValue(int i) {
        return i * i;
    }



}
