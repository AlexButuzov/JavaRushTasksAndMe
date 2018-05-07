package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {

    /**@date 14.04.2018
     * @author Butuzov A.N.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String fileSource = reader.readLine();
        String fileDestenation = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileSource);
        FileWriter fileWriter = new FileWriter(fileDestenation);
        boolean flag = false;
        while (fileReader.ready()) {
            if (flag) {
                flag = false;
                fileWriter.write(fileReader.read());
            } else {
                fileReader.read();
                flag = true;
            }
        }
        fileReader.close();
        fileWriter.close();

    }
}
