package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream valueOfSystemOutOnStartProgram = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream nextValueOfSystemOut = new PrintStream(byteArrayOutputStream);
        System.setOut(nextValueOfSystemOut);
        testString.printSomething();
        System.setOut(valueOfSystemOutOnStartProgram);
        String llineFromSystemOut = byteArrayOutputStream.toString();//.replaceAll("[\\n]","");
        String[] lineArrayFromSystemOut = llineFromSystemOut.trim().split(" ");
        int valueOne = Integer.parseInt(lineArrayFromSystemOut[0]);
        int valueTwo = Integer.parseInt(lineArrayFromSystemOut[2]);
        String actionWithValue = lineArrayFromSystemOut[1];
        int valueRezult = 0;
        switch (actionWithValue){
            case "*" : valueRezult = valueOne * valueTwo;
                break;
            case "+" : valueRezult =  valueOne + valueTwo;
                break;
            case "-" : valueRezult = valueOne - valueTwo;
                break;
        }
        System.out.print(llineFromSystemOut.trim());
        System.out.println(" " + valueRezult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
            //System.out.println("3 - 6 = ");
        }
    }
}

