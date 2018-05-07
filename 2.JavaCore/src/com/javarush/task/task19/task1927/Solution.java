package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    /**
     *
     * @date 18.04.2018
     * @author Butuzov A.N.
     */
    public static void main(String[] args) {
        PrintStream stateSystemOutOnStartProgram = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream nextSystemOut = new PrintStream(byteArrayOutputStream);
        System.setOut(nextSystemOut);
        testString.printSomething();
        System.setOut(stateSystemOutOnStartProgram);
        String[] outArray = byteArrayOutputStream.toString().split("\n");


        for (int i = 0; i < outArray.length; i++) {
            System.out.println(outArray[i]);
            if ((i % 2) != 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
