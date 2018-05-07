package com.javarush.task.task12.task1227;

/* 
Fly, Run, Swim для классов Duck, Penguin, Toad
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Fly {
        public void fly();
    }

    public interface Run {
        public void run();
    }

    public interface Swim {
        public void swim();
    }

    /**
     * 06.03.2018
     */
    public class Duck implements Fly, Run, Swim {

        public void fly(){}

        public void run(){}

        public void swim(){}

    }

    /**
     * 06.03.2018
     */
    public class Penguin implements Run, Swim {

        public void run(){}

        public void swim(){}
    }

    /**
     * 06.03.2018
     */
    public class Toad implements Swim {

        public void swim(){}

    }
}
