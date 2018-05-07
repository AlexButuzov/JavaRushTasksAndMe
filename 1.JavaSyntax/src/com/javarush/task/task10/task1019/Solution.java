package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {

    /**
     * 03.03.2018
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> listHashMap = new HashMap<String,Integer>();


        String idString = reader.readLine();
        if (!"".equals(idString)) {
            while (!"".equals(idString)){
                int id = Integer.parseInt(idString);
                String name = reader.readLine();
                listHashMap.put(name,id);
                idString = reader.readLine();
            }
        }


        Iterator iterator = listHashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            //HashMap.Entry pair = iterator.next();
            HashMap.Entry<String,Integer> pair = (HashMap.Entry<String, Integer>) iterator.next();
            System.out.println(pair.getValue() + " " + pair.getKey());
        }

    }
}
