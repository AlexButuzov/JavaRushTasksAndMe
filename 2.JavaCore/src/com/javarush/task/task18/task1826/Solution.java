package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if(args.length>0) {
            if ("-e".equals(args[0])) {
                try (FileInputStream fileName = new FileInputStream(args[1]);
                     FileOutputStream fileOutputName = new FileOutputStream(args[2])) {
                    while (fileName.available() > 0) {
                        int bufferSize = 64000;
                    if (bufferSize > fileName.available()) bufferSize = fileName.available();
                        byte[] buffer = new byte[bufferSize];
                        fileName.read(buffer);
                        fileOutputName.write(java.util.Base64.getEncoder().encode(buffer));
                    }
                    fileName.close();
                    fileOutputName.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //туда: byte[] result = java.util.Base64.getEncoder().encode(b);
                // обратно: byte[] result = java.util.Base64.getDecoder().decode(b);

            } else if ("-d".equals(args[0])) {
                try (FileInputStream fileName = new FileInputStream(args[1]);
                     FileOutputStream fileOutputName = new FileOutputStream(args[2])) {
                    while (fileName.available() > 0) {
                        int bufferSize = 64000;
                    if (bufferSize > fileName.available()) bufferSize = fileName.available();
                        byte[] buffer = new byte[bufferSize];
                        fileName.read(buffer);
                        fileOutputName.write(java.util.Base64.getDecoder().decode(buffer));
                    }
                    fileName.close();
                    fileOutputName.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
