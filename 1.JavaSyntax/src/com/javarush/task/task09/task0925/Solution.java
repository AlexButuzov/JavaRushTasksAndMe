package com.javarush.task.task09.task0925;
/*
Статики не на своем месте
*/

public class Solution {
    public static int A = 5;
    public static int B = 2 * A;
    public int C = 0;//A * B;
    public static int D = A * B;

    public  void main(String[] args) {
        Solution room = new Solution();
        room.A = 5;

        Solution.D = 5;
    }

    public int getA() {
        return A;
    }

}
