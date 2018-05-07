package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream valueOfSystemOutOnStart = System.out;
        ByteArrayOutputStream outputArray = new ByteArrayOutputStream();
        PrintStream nextValueOfSystemOut = new PrintStream(outputArray);
        System.setOut(nextValueOfSystemOut);
        testString.printSomething();
        System.setOut(valueOfSystemOutOnStart);
        String textToScreenAndToFile = outputArray.toString();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String fileOutputAddress = reader.readLine();
        reader.close();
        FileOutputStream fileOutputStream = new FileOutputStream( fileOutputAddress);
       // BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
        System.out.println(textToScreenAndToFile);
        fileOutputStream.write(textToScreenAndToFile.getBytes());
        //bufferedWriter.write(textToScreenAndToFile);
        //bufferedWriter.close();


        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

