package com.javarush.task.task14.task1404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Cat> cats = new ArrayList<Cat>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String name = reader.readLine();
        while ( !"".equals(name)) {
            cats.add(CatFactory.getCatByKey(name));
            name = reader.readLine();
        }
        reader.close();

        for(int  i = 0; i < cats.size(); i ++) {
            System.out.println(cats.get(i).toString());
        }

    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}