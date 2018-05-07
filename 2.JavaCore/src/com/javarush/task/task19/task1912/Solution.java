package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream systemOutOnStart = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream nextSystemOut = new PrintStream(byteArrayOutputStream);
        System.setOut(nextSystemOut);
        testString.printSomething();
        System.setOut(systemOutOnStart);
        String rezult = byteArrayOutputStream.toString().replace("te","??");
        System.out.println(rezult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
