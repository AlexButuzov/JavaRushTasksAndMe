package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] currentLine;
            if (fileScanner.hasNextLine()) {
                currentLine = fileScanner.nextLine().trim().split(" ");
            } else return null;
            String lastName = currentLine[0];
            String firstName = currentLine[1];
            String middleName = currentLine[2];
            int year = Integer.parseInt(currentLine[5]);
            int month = Integer.parseInt(currentLine[4]) - 1;
            int day = Integer.parseInt(currentLine[3]);
            GregorianCalendar calendar = new GregorianCalendar(year, month, day);
            Date birthDay = calendar.getTime();
            return new Person(firstName, middleName, lastName, birthDay);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
