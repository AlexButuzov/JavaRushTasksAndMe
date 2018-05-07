package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {

    /**22.02.2018
     * */
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Анна", false, 12, null);
        Human child2 = new Human("Анна1", false, 14, null);
        Human child3 = new Human("Peter", true, 12, null);


        ArrayList<Human> childrenList = new ArrayList<Human>();
        childrenList.add(child1);
        childrenList.add(child2);
        childrenList.add(child3);

        Human father = new Human("Pavel", true, 42, childrenList);
        Human mather = new Human("Olga", false, 41, childrenList);

        childrenList.clear();
        childrenList.add(father);
        Human grfather1 = new Human("Pavel1", true, 82, childrenList);
        Human grmather1 = new Human("Olga1", false, 71, childrenList);

        childrenList.clear();
        childrenList.add(mather);
        Human grfather2 = new Human("Pavel2", true, 82, childrenList);
        Human grmather2 = new Human("Olga2", false, 71, childrenList);

        System.out.println(grfather1.toString());
        System.out.println(grfather2.toString());
        System.out.println(grmather1.toString());
        System.out.println(grmather2.toString());
        System.out.println(mather.toString());
        System.out.println(father.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());

    }

    /**22.02.2018
     * */
    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        /**22.02.2018
         * */
        public Human(String name, boolean sex, int age, ArrayList<Human> addlist) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            if (addlist != null) {
                this.children.addAll(addlist);
            }
        }

        /**22.02.2018
         * */
        public Human() {
            new Human("",false,0,null);
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
