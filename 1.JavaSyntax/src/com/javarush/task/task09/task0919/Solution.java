package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    /**26.02.2018
    */
    public static void main(String[] args) {
        
        
        try{
        
        divisionByZero();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        
    }
    
    public static void divisionByZero() {
        

            System.out.println(34/ 0);

    }
}
