package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Thread5 extends Thread4 {
    @Override
    public void run() {
        String inputLine = "";
        int rezultInputnmbers = 0;
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        try {
             inputLine = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!"N".equals(inputLine)) {
            rezultInputnmbers += Integer.parseInt(inputLine);
            try {
                inputLine = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(rezultInputnmbers);

    }
}
