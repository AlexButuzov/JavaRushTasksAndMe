package com.javarush.task.task14.task1418;

import java.util.LinkedList;
import java.util.List;

/* 
Исправь четыре ошибки
*/

public class Solution {

    /**
     * 16.03.2018
     */
    public static void main(String[] args) {
        List<Number> list = new LinkedList<Number>();
        list = initList(list);
        printListValues(list);
        processCastedObjects(list);
        list.clear();
    }

    /**
     * 16.03.2018
     */
    public static List<Number> initList(List<Number> list) {

        list.add(new Double(1000f));
        list.add(new Double(0.));
        list.add(new Float(-90 / -3));
        list.add(new Double(78. / 68. * 1.));
        return list;
    }

    /**
     * 16.03.2018
     */
    public static void printListValues(List<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 16.03.2018
     */
    public static void processCastedObjects(List<Number> list) {
        for (Number object : list) {
            //Исправь 2 ошибки
            if (object instanceof Float) {
                Float number = (Float) object;
                System.out.println("Is float value defined? " + !(number.isNaN()));
            } else if (object instanceof Double) {
                Double number = (Double) object;
                System.out.println("Is double value infinite? " + number.isInfinite());
            }
        }
    }
}
