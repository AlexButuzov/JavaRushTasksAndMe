package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    /**22.03.2018
     * */
    public static String factorial(int n) {
        //add your code here
        BigInteger rezultFactorial = null;
        String rezultModul = "";
        if (n > 0) {

            rezultFactorial= BigInteger.valueOf((long) 1);
            for (int conter = 1; conter < n + 1; conter++) {
                rezultFactorial= rezultFactorial.multiply( BigInteger.valueOf( (long) conter));

            }
            rezultModul = String.valueOf( rezultFactorial);
        } else if (n == 0) rezultModul = "1";
        else rezultModul = "0";



        return rezultModul;
    }
}
