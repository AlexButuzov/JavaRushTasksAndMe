package com.javarush.task.task12.task1221;

/* 
Все мы немного кошки…
*/

public class Solution {

    /**
     * 06.03.2018
     *
     */
    public static void main(String[] args) {
        Pet pet = new Cat();

        System.out.println(pet.getName());
    }

    public static class Pet {
        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet {

        /**
         * 06.03.2018
         *
         */
        public String getName() {
            return "Я - кот";
        }
    }
}
