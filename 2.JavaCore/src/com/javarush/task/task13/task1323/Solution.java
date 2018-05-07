package com.javarush.task.task13.task1323;

/* 
Интерфейс Updatable в классе Screen
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable extends Selectable {
        void refresh();
    }

    /**
     * 13.03.2018
     */
    class Screen implements Updatable{
        public void onSelect(){}

        public void refresh() {}

    }
}
