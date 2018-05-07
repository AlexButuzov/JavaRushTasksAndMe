package com.javarush.task.task09.task0920;

/* 
Обратный отсчёт
*/

public class Solution {

    /**
     * 27.02.2017
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);

            //напишите тут ваш код
            try {
                Thread.sleep(100);
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }
}
