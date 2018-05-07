package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {

        byte[][] workBoard = new byte[a.length + 1][a.length + 1];
        int lengthArray = a.length;
        for (int i = 0; i < lengthArray; i++)
            for (int j = 0; j < lengthArray; j++) workBoard[i][j] = a[i][j];


        int counter = 0;
        for (int i = 0; i < lengthArray; i++) {
            for (int j = 0; j < lengthArray; j++) {
                if ((workBoard[i][j] == 1)
                        & (workBoard[i][j + 1] == 0)
                        & (workBoard[i + 1][j] == 0)
                        & (workBoard[i + 1][j + 1] == 0)) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
