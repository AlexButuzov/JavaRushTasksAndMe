package com.javarush.task.task12.task1223;

/* 
И снова Пушистик…
*/

public class Solution {

    /**
     * 06.03.2018
     */
    public static void main(String[] args) {
        Pet pet = new Cat();
        pet.setName("Я - пушистик");

        System.out.println(pet.getName());
    }

    public static class Pet {
        protected String name;

        public Pet() {
        }

        public final String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    /**
     * 06.03.2018
     */
    public static class Cat extends Pet {
        public void setName(String name) {
            this.name = "";
        }

    }
}
