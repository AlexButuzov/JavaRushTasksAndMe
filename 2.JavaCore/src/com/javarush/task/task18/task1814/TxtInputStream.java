package com.javarush.task.task18.task1814;

import java.io.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream  {
    private FileInputStream originalInputStream;

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, FileNotFoundException, IOException {
        super(fileName);
        String fileExtension = fileName.substring( fileName.length() - 4, fileName.length());
        if (!String.valueOf(".txt").equals(fileExtension)) {
           super.close();
           throw new UnsupportedFileNameException();

        } 
    }

    

    public TxtInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    public TxtInputStream(FileDescriptor fdObj) {
        super(fdObj);
    }

    @Override
    public int read() throws IOException {
        return super.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return super.read(b, off, len);
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }

    @Override
    public void close() throws IOException {
        super.close();
    }

    public static void main(String[] args) {
    }
}

