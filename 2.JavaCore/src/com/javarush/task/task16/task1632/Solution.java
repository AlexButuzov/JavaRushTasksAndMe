package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.javarush.task.task16.task1632.*;

public class Solution {
    public static List<Thread4> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
        /*threads.get(3).start();
        while (threads.get(3).alive) {
            threads.get(3).showWarning();
        }

        System.out.println("4 нить остановлена");*/
    }
}