package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {

       // System.out.println(new GenerateThread());
        new GenerateThread();
    }

    /**
     * 24.03.2018
     */
    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(Integer.toString(++countCreatedThreads));
            this.start();
        }

        @Override
        public void run() {
            if (countCreatedThreads <= Solution.count) {
                GenerateThread nextThread = new GenerateThread();
                System.out.println(nextThread.toString());
            }

        }

        @Override
        public String toString() {
            return (super.getName() + " created" );
        }
    }
}
