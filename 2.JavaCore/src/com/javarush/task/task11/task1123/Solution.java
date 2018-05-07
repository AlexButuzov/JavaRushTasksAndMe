package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    /**05.03.2018
     */
    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //Напишите тут ваше решение
        int minElement = array[0];
        int maxElement = array[0];
        for (int counter = 0; counter < array.length; counter++) {

            if (array[counter] > maxElement) {
                maxElement = array[counter];
            } else if (array[counter] < minElement) {
                minElement = array[counter];
            }
        }

        return new Pair<Integer, Integer>(minElement, maxElement);
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
