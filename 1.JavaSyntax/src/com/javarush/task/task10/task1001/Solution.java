package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    
    
    /**01.03.2018
     */
     public static void main(String[] args) {
        int a = 0;
        int b = (int) a + 46;
        byte c = (byte) (a * b);
        double f = (double) 1234.15;
        long d = (long) (a + f / c + b);
        System.out.println(d);
    }
}
