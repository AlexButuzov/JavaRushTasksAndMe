package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {

    /**22.02.2018
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        s = s.trim();

        String[] stroki = s.split(" +");
        String itog = "";
        for ( int counter = 0; counter < stroki.length; counter ++) {
            itog +=stroki[counter].substring(0,1).toUpperCase();
            itog +=stroki[counter].substring(1) + " ";

        }

        System.out.println(itog);
    }


}
