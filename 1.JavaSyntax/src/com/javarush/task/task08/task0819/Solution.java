package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
Set из котов
*/

public class Solution {




    /**22.02.2018
     * */
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Iterator<Cat> iter = cats.iterator(); //
        if (iter.hasNext()) {
            iter.next();
            iter.remove();
        }

        printCats(cats);
    }


    /**22.02.2018
     * */
    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> cats = new HashSet<Cat>();
        cats.add(new Cat("Васька"));
        cats.add(new Cat("Васька1"));
        cats.add(new Cat("Васька2"));

        return cats;
    }

    /**22.02.2018
     * */
    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        /*Iterator<Cat> iter = cats.iterator(); //
        while (iter.hasNext()) {
            Cat catOut = iter.next();
            System.out.println(catOut.name);
        }*/

        for (Cat catOut: cats  ) {
            System.out.println(catOut.name);
        }
    }

    /**22.02.2018
     * */
    // step 1 - пункт 1
    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        public Cat() {
            this.name = "Stop";
        }
    }

}