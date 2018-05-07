package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    /**
     * 06.03.2018
     */
    public static class Imploers implements Businessman {
        @Override
        public void workHard() {

        }
    }

    /**
     * 06.03.2018
     */
    public static class CTO extends Imploers implements Businessman {

    }
}
