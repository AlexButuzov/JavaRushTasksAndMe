package com.javarush.task.task08.task0827;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import java.util.Locale;

/*
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Locale locale = new Locale("en", "EN"); //прописываем локальные настройки, для определения месяцев на английском
        Locale.setDefault(locale);
        DateTimeFormatter  format =  new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("MMMM d yyyy").toFormatter();

        LocalDate taskDate = LocalDate.parse(date, format);

        if ( taskDate.getDayOfYear() %2 == 0) {
            return false;
        } else  {
            return true;
        }
    }
}