package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    public static BufferedReader reader1;
    public static BufferedReader reader2;
    public static String[] stringsFromFile1 = new String[2];
    public static String[] stringsFromFile2 = new String[2];

    public static void main(String[] args) throws IOException {
        /*boolean add = lines.add(new LineItem());
        Type newLine = Type.REMOVED;*/
        initializeSourceFile();
        firstInitializeLinesFromFiles();

        //while?? reeder-ы redy ? или только один из них?
        while ((reader1.ready()) && (reader2.ready())) {
            initializeLinesFromFiles();
            compareLinesFromFile();
        }
        if (reader2.ready()) addAllLinesFromFile2();
        if (reader1.ready()) addAllLinesFromFile1();

        reader1.close();
        reader2.close();
    }

    private static void firstInitializeLinesFromFiles() throws IOException {
        if (reader1.ready()) {
            stringsFromFile1[0] = reader1.readLine().trim();
        }

        if (reader1.ready()) {
            stringsFromFile1[1] = reader1.readLine().trim();
        }

        if (reader2.ready()) {
            stringsFromFile2[0] = reader2.readLine().trim();
        }
        if (reader2.ready()) {
            stringsFromFile2[1] = reader2.readLine().trim();
        }
    }

    public static void addAllLinesFromFile2() throws IOException {
        while (reader2.ready()) {
            initializeLinesFromFiles();
            if (stringsFromFile2[0] != "") {
                lines.add(new LineItem(Type.ADDED, stringsFromFile2[0]));
                stringsFromFile2[0] = stringsFromFile2[1];
                stringsFromFile2[1] = "";
            }


        }

    }

    public static void addAllLinesFromFile1() throws IOException {
        while (reader1.ready()) {
            initializeLinesFromFiles();
            if (stringsFromFile1[0] != "") {
                lines.add(new LineItem(Type.REMOVED, stringsFromFile1[0]));
                stringsFromFile1[0] = stringsFromFile1[1];
                stringsFromFile1[1] = "";
            }
        }

    }

    public static void initializeSourceFile() throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String file1 = reader.readLine().trim();
        String file2 = reader.readLine().trim();
        reader.close();
        reader1 = new BufferedReader(new FileReader(file1));
        reader2 = new BufferedReader(new FileReader(file2));

    }


    public static void compareLinesFromFile() throws IOException {

        //""?
        if ((stringsFromFile1[0].length() != 0)
                && (stringsFromFile2[0].length() != 0)
                && (stringsFromFile1[0].equals(stringsFromFile2[0]))) {
            //lines.add(new LineItem());
            //        Type newLine = Type.REMOVED;*/
            lines.add(new LineItem(Type.SAME, stringsFromFile1[0]));
            stringsFromFile1[0] = stringsFromFile1[1];
            stringsFromFile1[1] = "";
            stringsFromFile2[0] = stringsFromFile2[1];
            stringsFromFile2[1] = "";
            //same
            // del 0 : 0

        } //else
            if ((stringsFromFile1[0].equals(stringsFromFile2[1]))
                    && (stringsFromFile1[0].length() != 0)
                    && (stringsFromFile2[0].length() != 0)) {
            //added stringsFromFile2[0]
            //same stringsFromFile2[1]
            //del 0 : 0,1
            lines.add(new LineItem(Type.ADDED, stringsFromFile2[0]));
            lines.add(new LineItem(Type.SAME, stringsFromFile1[0]));

            stringsFromFile1[0] = stringsFromFile1[1];
            stringsFromFile1[1] = "";
            stringsFromFile2[0] = "";
            stringsFromFile2[1] = "";
        }
       // else
            if ((stringsFromFile1[1].equals(stringsFromFile2[0]))
                    && (stringsFromFile2[0].length() != 0)
                    && (stringsFromFile1[0].length() != 0) ) {
            //REMOVED stringsFromFile1[0]
            //same stringsFromFile1[1]
            //de; 0,1 : 0

            lines.add(new LineItem(Type.REMOVED, stringsFromFile1[0]));
            lines.add(new LineItem(Type.SAME, stringsFromFile1[1]));

            stringsFromFile1[0] = "";
            stringsFromFile1[1] = "";
            stringsFromFile2[0] = stringsFromFile2[1];
            stringsFromFile1[1] = "";

        }
    }


    public static void initializeLinesFromFiles() throws IOException { // ДОДЕЛАТЬ !


        if (reader1.ready()) if ("".equals(stringsFromFile1[0])) stringsFromFile1[0] = reader1.readLine().trim();
        if (reader1.ready()) {
            if ("".equals(stringsFromFile1[1])) stringsFromFile1[1] = reader1.readLine().trim();
        }




        if (reader2.ready()) if ("".equals(stringsFromFile2[0])) stringsFromFile2[0] = reader2.readLine().trim();
        if (reader2.ready()) {
            if ("".equals(stringsFromFile2[1])) stringsFromFile2[1] = reader2.readLine().trim();
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Solution.Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
