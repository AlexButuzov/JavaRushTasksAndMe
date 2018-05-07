package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    /**
     * 06.03.2018
     */
    public static String getObjectType(Object o) {
        //напишите тут ваш код
        String rezultStr ;
        if (o instanceof Tiger) {
            rezultStr = "Тигр";
        } else if (o instanceof Lion) {
            rezultStr = "Лев";
        } else if(o instanceof Bull) {
            rezultStr = "Бык";
        } else if(o instanceof Cow) {
            rezultStr = "Корова";
        } else if (o instanceof Cat) {
            rezultStr = "Кот";
        } else if (o instanceof Animal) {
            rezultStr = "Животное";
        } else {
            rezultStr = "не животное";
        }

        return rezultStr;
    }

    public static class Animal {
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }


}
