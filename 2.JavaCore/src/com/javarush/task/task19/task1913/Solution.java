package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream valueOfSystemOutJnStartProgram = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newValueOfSystemOut = new PrintStream(byteArrayOutputStream);
        System.setOut(newValueOfSystemOut);
        testString.printSomething();
        System.setOut(valueOfSystemOutJnStartProgram);
        String rezult = byteArrayOutputStream.toString().replaceAll("[^0-9]","");
        System.out.println(rezult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
