package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {

    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
       if (args.length > 0) {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            while (reader.ready()) {
                String currentLine = reader.readLine();
                Person currentPerson = null;
                if (! "".equals(currentLine)) currentPerson = convertLineToPeple(currentLine); // Иванов Иван Иванович 31 12 1987
                if ( currentPerson != null)PEOPLE.add(currentPerson);
            }
            reader.close();
        }

    }

    public static Person convertLineToPeple(String currentLine) {
        String[] lineByWord = currentLine.trim().split(" ");
        int size = lineByWord.length;
        int year = Integer.parseInt(lineByWord[size - 1]);
        int month = Integer.parseInt(lineByWord[size - 2]);
        int day = Integer.parseInt(lineByWord[size - 3]);
        /*GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        Date birthDay = calendar.getTime();
        */Date birthDay = new Date(year - 1900, month - 1, day);

        String name = currentLine.replaceAll("[0-9]" , "").trim();

        /*String name = "";
        for (int i = 0; i < (size - 3); i++) {
            name += String.valueOf(lineByWord[i]) + " ";
        }
        name.trim();*/
        return new Person(name, birthDay);
    }
}
