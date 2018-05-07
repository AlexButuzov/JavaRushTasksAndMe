package com.javarush.task.task12.task1231;

/* 
Ненужные абстракции
*/

public class Solution {

    public static void main(String[] args) {
        Horse horse = new Pegas();
        horse.run();
    }

    /**
     * 06.03.2018
     */
    public static interface Fly {
        public  void fly();
    }

    public static class Horse {
        public void run() {

        }
    }

    /**
     * 06.03.2018
     */
    public static class Pegas extends Horse implements Fly {
        public  void fly() {

        }
    }

    /**
     * 06.03.2018
     */
    public abstract static class SwimPegas extends Pegas {
        public abstract void swim();
    }

}
