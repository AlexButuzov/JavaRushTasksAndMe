package com.javarush.task.task17.task1722;

/* 
Посчитаем
*/

public class Solution {

    /**29.03.2018
     * */
    public static int[] values = new int[105];

    /**29.03.2018
     * */
    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        counter1.start();
        counter1.join();
        Counter counter2 = new Counter();
        counter2.start();
        counter2.join();
        Counter counter3 = new Counter();
        counter3.start();
        counter3.join();
        Counter counter4 = new Counter();
        counter4.start();
        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }


    public static Integer count = 0;

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {

        /**29.03.2018
         * */
        @Override
        public  void run() {
            do {
                synchronized (values) {

                    values[getCount()] = 1;
                    incrementCount();
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException exp) {
                    exp.printStackTrace();
                }
            }
            while (getCount() < 100);
        }
    }
}
