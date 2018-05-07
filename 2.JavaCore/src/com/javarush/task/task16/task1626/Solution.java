package com.javarush.task.task16.task1626;

import java.util.Date;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException{
        final Thread  thread1 = new Thread(new CountDownRunnable(), "Уменьшаем");
        thread1.start();


        final Thread thread2 = new Thread(new CountUpRunnable(), "Увеличиваем");
        //Date dat1 = new Date();

        thread2.start();
        //thread2.join();

        //System.out.println( (new Date()).getTime() - dat1.getTime());



    }

    public static class CountUpRunnable implements Runnable{
        //Add your code here - добавь код тут
        private int countIndexUp = Solution.number;

        public void run() {

            try {
                int counter = 1;
                while (true) {
                    Thread.sleep(500);
                    System.out.println(toString(counter));
                    counter ++;
                    if (countIndexUp < counter) {
                       // Thread.sleep(370);
                        return;


                    }

                }
            } catch (InterruptedException e) {
            }
        }

        public String toString(int count) {
            return Thread.currentThread().getName() + ": " + count;
        }
    }


    public static class CountDownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) {
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
