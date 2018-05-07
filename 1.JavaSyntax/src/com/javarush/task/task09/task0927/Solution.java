package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    /***
     * 28.02.2018
     * * @return
     */
    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> tempCat = new HashMap<>() ;

        for (int i = 0; i < 10; i++) {
            Cat cats = new Cat(" name " + i);
            tempCat.put(" name " + i, cats);
        }
        return tempCat;
    }


    /***
     * 28.02.2018
     * * @return
     */

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> catterSet = new HashSet<>();

        for(Map.Entry<String , Cat> pair: map.entrySet()) {
            catterSet.add(pair.getValue());
        }
        return catterSet;

    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
