package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    /**
     * 27.02.2108
     * @param counter
     * @return
     */
    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> tempArrayList = new ArrayList<>();
        tempArrayList.add(creatArray(5));
        tempArrayList.add(creatArray(2));
        tempArrayList.add(creatArray(4));
        tempArrayList.add(creatArray(7));
        tempArrayList.add(creatArray(0));
        return  tempArrayList;

    }

    /**
     * 27.02.2108
     * @param counter
     * @return
     */
    private  static int[] creatArray(int counter) {
        //напишите тут ваш код
        ArrayList<Integer> tempList= new ArrayList<>();
        int []array1 = new int[counter];
        if (counter > 0) {

            for (int i = 0; i < counter; i++) {
                array1[i]=i;
            }

        }

        return array1;

    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
