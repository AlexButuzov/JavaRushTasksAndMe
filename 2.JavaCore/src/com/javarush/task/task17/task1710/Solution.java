package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.System.in;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("?????? ????", new Date()));  //??????? ???????    id=0
        allPeople.add(Person.createMale("?????? ????", new Date()));  //??????? ???????    id=1
    }

    public static void main(String[] args) {
        //start here - ????? ???
        String parametrsLine = getLineFromKeyBoard();
        while (!"exit".equals(getLineFromKeyBoard())) {
            String[] parametersArray = parametrsLine.split(" ");
            switch (parametersArray[0]) {
                case "-c":
                    allPeople.add(PersonUpd(parametersArray));
                    break;
                case "-u":
                    allPeople.set(Integer.parseInt(parametersArray[1]), PersonUpd(parametersArray));

                    break;
                case "-d":
                    allPeople.remove(Integer.parseInt(parametersArray[1]));
                    break;
                case "-i":
                    toPrint(allPeople.get(Integer.parseInt(parametersArray[1])));////////
                    break;
            }
        }

    }

    private static void toPrint(Person person) {
        String sexPrint = "";
        if (Sex.MALE.equals(person.getSex())) { sexPrint = "?";}
        else if (Sex.FEMALE.equals(person.getSex())) { sexPrint = "?"; }
        Locale.setDefault(Locale.ENGLISH);

        System.out.println(person.getName() + " " + sexPrint  + " " + convertDay(person.getBirthDay()));
    }

    private static String convertDay(Date birthDay) {
        String makeStringBirthDay = birthDay.toString();
        //?????? ??????, ??????????? simple - day formatter ??? ?????? ?????
        Locale locale = new Locale("en", "EN"); //??????????? ????????? ?????????, ??? ??????????? ??????? ?? ??????????
        Locale.setDefault(locale);
        DateTimeFormatter format =  new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("d/mm/yyyy").toFormatter();

        LocalDate taskDate = LocalDate.parse(makeStringBirthDay, format);
        //????? ? ??????????????? ???????
        int year = taskDate.getYear(); // 1999 ?.
        Month month = taskDate.getMonth(); // 12-? ?????
        int day = taskDate.getDayOfMonth();

        return  String.valueOf(day) + String.valueOf(month) + String.valueOf(year);
    }

    private static Person PersonUpd(String[] parametersArray) {
        Person tempPerson = null;

        if ("?".equals(parametersArray[parametersArray.length - 2])) {
            tempPerson = Person.createFemale(parametersArray[parametersArray.length - 3], StringToDate(parametersArray[parametersArray.length - 1]));

        } else if ("?".equals(parametersArray[parametersArray.length - 2])) {
            tempPerson = Person.createMale(parametersArray[parametersArray.length - 3], StringToDate(parametersArray[parametersArray.length - 1]));
        }

        return tempPerson;
    }

    private static Date StringToDate(String stroka) {
        Locale.setDefault(Locale.ENGLISH);
        LocalDate taskDate = null;

        Date date =  Date.from(Instant.parse(stroka));
        return  date;
    }

    private static String getLineFromKeyBoard() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));
        String rezult = null;
        try {
            rezult = reader.readLine();
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        rezult = rezult.substring(rezult.indexOf("-"));
        rezult.trim();
        return rezult;
    }

}
