package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // алфавит
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();

        /*ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++) {
            alphabet.add(abcArray[i]);
        }*/
        HashMap<Character, Integer> alphabetMap = new HashMap<Character, Integer>(); // htoibmn ghj,ktve!!!
        for (int i = 0; i < abcArray.length; i++) {
            alphabetMap.put(abcArray[i],0);
        }


        // ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        // напишите тут ваш код

        for (int i = 0; i < list.size() ; i++) {
            String stroka = list.get(i);// читаем текущую строку;
            stroka= stroka.toLowerCase().trim();
            while (stroka.length()>0) {
                char simvol = stroka.substring(0, 1).charAt(0); // вырезаем первый символ
                stroka = stroka.substring(1); // удаляем первый символ из строки

                if (alphabetMap.containsKey(simvol)) { // проверка является ли символ буквой

                    Integer counter = Integer.valueOf(alphabetMap.get(simvol) + 1); //  получаем значения счетчика и добавляем ему 1ж
                    alphabetMap.replace(simvol, counter); // вводим новое значение счетчика

                    //alphabetMap.put(simvol, counter);//2
                }
            }
        }

        //вывод

        for (int i = 0; i < abcArray.length; i++) {
            StringBuilder s = new StringBuilder();
            System.out.println(s.append(abcArray[i] + " " + alphabetMap.get(abcArray[i])));

        }

        alphabetMap.clear();

    }

}
