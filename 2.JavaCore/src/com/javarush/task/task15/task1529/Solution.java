package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    /**22.03.2018
     * */
    static {
        //add your code here - добавьте код тут
        result =null;
        reset();
    }

    public static Flyable result;

    /**22.03.2018
     * */
    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in) );
        String parametr = null;
        try {
            parametr = reader.readLine();
            reader.close();
        } catch (IOException exp) {

        }

        if ( "helicopter".equals(String.valueOf(parametr)) ) {
            result = new  Helicopter();
        }
        if ( "plane".equals(String.valueOf(parametr)) ) {
            int countPassgers;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(System.in) );
                parametr = reader.readLine();
                reader.close();
                countPassgers = Integer.parseInt(parametr);
                result = new Plane(countPassgers);

            } catch (IOException exp) {

            }

        }
    }
}
