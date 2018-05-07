package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

public class Solution {
    public volatile static int COUNT = 4;

    /**
     * 24.03.2018
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            SleepingThread currentThread = new SleepingThread();
            //напишите тут ваш код
            currentThread.join();

        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countDownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        /**
         * 24.03.2018
         */
        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDownIndex == 0) return;
                //напишите тут ваш код
                try {
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("Нить прервана");
                        return;
                    }
                    Thread.sleep(10);
                } catch (InterruptedException exp) {
                    System.out.println(exp);
                }
            }

        }

        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
