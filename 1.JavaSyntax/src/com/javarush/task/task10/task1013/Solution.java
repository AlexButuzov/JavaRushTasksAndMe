package com.javarush.task.task10.task1013;
public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name = "";
        private String soname = "";
        private int age = 0;
        private boolean sex = false;
        private int hight = 0;
        private int weigth = 0;

        public Human() {
            this.name = "none";
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, String soname) {
            this.name = name;
            this.soname = soname;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, String soname, int age) {
            this.name = name;
            this.soname = soname;
            this.age = age;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String soname, boolean sex) {
            this.name = name;
            this.soname = soname;
            this.sex = sex;
        }

        public Human(String name, String soname, int age, boolean sex) {
            this.name = name;
            this.soname = soname;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, int age, boolean sex, int weigth) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.weigth = weigth;
        }


    }
}

