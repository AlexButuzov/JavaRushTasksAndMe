package com.javarush.task.task14.task1407;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Player and Dancer
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;
        String key = reader.readLine();
        key.trim();
        if (key != null) {
        while (!key.equals("exit")) {
            if ("player".equals(key)) {
                person = new Player();
            } else if ("dancer".equals(key)) {
                person = new Dancer();
            }
            haveRest(person);
             key = reader.readLine();
             key.trim();
        }
        }
        reader.close();
    }

    /**14.03.2018
    */
    public static void haveRest(Person person) {
        //напишите тут ваш код
        if (person instanceof Player) {
            Player player1 = (Player) person;
            player1.play();
        } else if (person instanceof Dancer) {
            Dancer dance1 = (Dancer) person;
            dance1.dance();
        }
    }

    interface Person {
    }

    static class Player implements Person {
        void play() {
            System.out.println("playing");
        }
    }

    static class Dancer implements Person {
        void dance() {
            System.out.println("dancing");
        }
    }
}
