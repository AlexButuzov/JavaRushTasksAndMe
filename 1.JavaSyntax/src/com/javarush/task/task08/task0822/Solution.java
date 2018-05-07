package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.abs;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array)  {
        // find minimum here — найти минимум тут
        Collections.sort(array);
        return array.get(0);

    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        List<Integer> llist = new ArrayList<>();
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );
        int N = Integer.parseInt( reader.readLine());
        for (int i = 0; i < abs(N); i ++) {
            int elemetn = Integer.parseInt( reader.readLine());
            llist.add(elemetn);
        }
        return llist;

    }
}
