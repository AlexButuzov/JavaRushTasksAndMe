package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    /**
     * @date 16.04.2018
     * @author Butuzov A.N.
     * @param args null
     */
    public static void main(String[] args) {
        PrintStream systemOutOnStrat = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(systemOutOnStrat);
        String rezult = byteArrayOutputStream.toString().toUpperCase();
        System.out.println(rezult);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
