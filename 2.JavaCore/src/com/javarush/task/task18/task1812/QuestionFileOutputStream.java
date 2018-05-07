package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    public AmigoOutputStream amigoOutStream;
    
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        String answer = reader.readLine();
        reader.close();
        if ("Д".equals(answer)) {
            // закрыть поток
            amigoOutStream.close();
        }
    }
    
    QuestionFileOutputStream(AmigoOutputStream amigoOutStream) {
        this.amigoOutStream = amigoOutStream;
    }
    
    public void flush() throws IOException {
        amigoOutStream.flush();
    }

    public void write(int b) throws IOException {
        amigoOutStream.write( b );
    }

    public void write(byte[] b) throws IOException {
        amigoOutStream.write( b );
    }

    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutStream.write(b, off, len);
    }

}

