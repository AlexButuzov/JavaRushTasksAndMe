package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        /*ArrayList<String>[] createArList = new  ArrayList[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                createArList[i].add(String.valueOf(j));
            }

        }
        return createArList;*/
        ArrayList<String>[] createArList = new ArrayList[] {
                        new ArrayList<String>(),new ArrayList<String>()
                };
        createArList[0].add(0,"ijhkjh");
        createArList[1].add( 0,"ugkug");
        return createArList;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}