package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * 06.03.2018
     */
    public interface Fly {
        void fly();
    }


    public interface Climb {
        void climb();
    }

    public interface Run {
        void run();
    }

    /**
     * 06.03.2018
     */
    public class Cat implements Run, Climb {


        public void climb() {
            int count = 0;
        }

        public void run() {
            int count = 0;
        }
    }

    /**
     * 06.03.2018
     */
    public class Dog implements  Run {

        public void run() {
            int count = 0;
        }
    }

    public class Tiger extends Cat {
    }

    /**
     * 06.03.2018
     */
    public class Duck implements Run, Fly {
        public void run() {
            int count = 0;
        }

        public void fly() {
            int count = 0;
        }
    }
}
