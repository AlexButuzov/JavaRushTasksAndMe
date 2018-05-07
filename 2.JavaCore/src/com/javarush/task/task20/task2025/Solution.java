package com.javarush.task.task20.task2025;

import java.util.List;

import static com.javarush.task.task20.task2025.ArmstrongNumbersMultiSetLongOpt.generate;
//import com.javarush.task.task20.task2025.ArmstrongNumbersMultiSetLongOpt;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N)  {
        long[] result = null;
        try {
            if (N >= 0) {
                int currentNumberOfDigits = 1;
                Long currenCompare = N;
                while (currenCompare > 10) {
                    currenCompare /= 10;
                    currentNumberOfDigits++;
                }

                List<Long> list = generate(currentNumberOfDigits);

                int sizeList = list.size();
                result = new long[sizeList];
                for (int i = 0; (i < sizeList - 1) & (list.get(i) < N); i++) { //
                   if (list.get(i) < N) {
                        result[i] = list.get(i);
                   }
                }
            } else {
                result = new long[0];
                result[0] = 0;
            }
        } catch (Exception es) {
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNumbers(9199999999999999999L)[0]);
    }
}
