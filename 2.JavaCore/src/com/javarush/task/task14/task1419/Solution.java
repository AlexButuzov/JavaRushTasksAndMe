package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
       //1
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        //2
        try {
            int array[] = new int[2];
            System.out.println("Доступ к третьему элементу:" + array[3]);
        }catch(IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        //3
        try {
            int array[] = new int[2];
            String stroka = "ergervg";

         //   array[0] = stroka;
        }catch(ArrayStoreException  e) {
            exceptions.add(e);
        }

        //4
        try {
            String stroka = "ergervg";
           // char x = (char) (int) ( double) (byte) (boolean) stroka;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        //5
        try {
            int count = -5;
            int array[] = new int[count];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        //6
        try {
            LinkedList<Integer> llist = new LinkedList<Integer>();
            llist.add(null);
            llist.get(0);

        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        //7
        try {
            String stroka= "ergerg";
            int number = Integer.parseInt(stroka);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        //8

    }
}
