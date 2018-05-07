package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
            System.in.close();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }


    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private  StringBuffer buffer = new StringBuffer();


        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {


            return buffer.toString();
        }

        @Override
        public void run() {

            FileReader readerFile = null;
            try {
                readerFile = new FileReader(fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                interrupt();
            }
            Scanner scanReader = new Scanner(readerFile);

            while (scanReader.hasNext()) {
                buffer.append(scanReader.next() + " ");
            }
            scanReader.close();
            try {
                readerFile.close();
            } catch (IOException expIO) {
                expIO.printStackTrace();
            }

        }
    }
}
