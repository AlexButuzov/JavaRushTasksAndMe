package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;
import java.lang.*;


/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream fileOutStr;

    AmigoOutputStream(FileOutputStream fileOutStrImput) throws IOException {
        super(fileOutStrImput.getFD());
        this.fileOutStr = fileOutStrImput;
    }


    public static void main(String[] args) throws IOException {
        new AmigoOutputStream(new FileOutputStream(fileName));

    }


    @Override
    public void write(int b) throws IOException {
        fileOutStr.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutStr.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutStr.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        fileOutStr.close();
    }


    @Override
    public void flush() throws IOException {
        fileOutStr.flush();

    }
}
