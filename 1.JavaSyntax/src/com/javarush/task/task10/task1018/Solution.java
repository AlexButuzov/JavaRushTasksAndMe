package com.javarush.task.task10.task1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Поправочки нужны
*/

public class Solution {

    /**
     * 03.03.2019
     */
    static HashMap<Integer, String> map;
    static Integer index;
    static String name;


    /**
     * 03.03.2019
     */
    public Solution() {
        this.map = new HashMap<Integer, String>();
        //map.put(index, name);
    }


    /**
     * 03.03.2019
     */
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            int index = Integer.parseInt(reader.readLine());
            String name = reader.readLine();
            map.put(index, name);

        }

        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            index = pair.getKey();
            name = pair.getValue();
            System.out.println("Id=" + index + " Name=" + name);
        }
    }
}
