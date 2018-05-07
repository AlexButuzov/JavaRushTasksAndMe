package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {

    /**
     * 23.02.2018
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        //List<String> addresses = new ArrayList<String>();
        Map<String,String> addressesTown = new HashMap<>();
        while (true) {
            String Town = reader.readLine();
            if (Town.isEmpty()) break;

            addressesTown.put(Town,reader.readLine());
        }

        //read home number
        //int houseNumber = Integer.parseInt(reader.readLine());
        String keyAsk = reader.readLine();
        if (keyAsk != null) {
            System.out.println(addressesTown.get(keyAsk));
        }

        /*if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familySecondName = addresses.get(houseNumber);
            System.out.println(familySecondName);
        }*/
    }
}
