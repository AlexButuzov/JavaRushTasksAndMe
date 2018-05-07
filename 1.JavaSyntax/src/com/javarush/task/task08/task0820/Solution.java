package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Set;

/* 
Множество всех животных
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }

        return result;
    }

    public static Set<Dog> createDogs() {
        //напишите тут ваш код
        HashSet<Dog> result1 = new HashSet<Dog>();
        for ( int i = 0; i < 3 ; i++) {
           result1.add(new Dog());
        }
        return result1;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        //напишите тут ваш код
        Set<Object> jjoin = new HashSet<Object>();
        jjoin.addAll(cats);
        jjoin.addAll(dogs);

        return jjoin;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        //напишите тут ваш код
        for ( Cat cater : cats) {
            pets.remove(cater);
        }
    }

    public static void printPets(Set<Object> pets) {
        //напишите тут ваш код
        for ( Object peter : pets) {
            System.out.println(peter.toString());
        }
    }

    //напишите тут ваш код
    public static class Cat {
        String name;

        public Cat() {
            name = "";
        }
    }

    public static class Dog {
        String name;

        public Dog() {
            name = "";
        }
    }
}
