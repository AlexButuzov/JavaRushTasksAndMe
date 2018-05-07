package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {

    /**23.02.2018
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> monthArrayList = new ArrayList<>();
        Collections.addAll(monthArrayList,"January", "February", "March",
                "April", "May", "June", "July", "August",
                "September", "October", "November", "December");

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        String month = reader.readLine();

        for (int counter = 0; counter < monthArrayList.size(); counter ++) {
            String curMonth = monthArrayList.get(counter);
            if (curMonth.equals(month)) {
                System.out.println(month +" is " + (counter + 1) +  " month");
                break;
            }
        }
    }
}
