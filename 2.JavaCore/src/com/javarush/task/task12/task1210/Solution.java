package com.javarush.task.task12.task1210;

/* 
Три метода и максимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    /**05.03.2018
    */
    public static int max(int count1, int count2) {
        
        int rezult;
        
        if (count1 > count2) {
            rezult = count1;
        } else {
            rezult = count2;
        }
        
        return rezult;
        
    }
    
    /**05.03.2018
    */
    public static long max(long count1L, long count2L) {
         
        long rezult;
        
        if (count1L > count2L) {
            rezult = count1L;
        } else {
            rezult = count2L;
        }
        
        return rezult;
        
    }
    
    /**05.03.2018
    */
    public static double max(double count1D, double count2D) {
         
        double rezult;
        
        if (count1D > count2D) {
            rezult = count1D;
        } else {
            rezult = count2D;
        }
        
        return rezult;
        
    }
}
