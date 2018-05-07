package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.BufferUnderflowException;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут
    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        try{
            String s=new BufferedReader(new InputStreamReader(System.in)).readLine();
            if(s.equals(Planet.EARTH))thePlanet=Earth.getInstance();
            else if(s.equals(Planet.MOON))thePlanet=Moon.getInstance();
            else if(s.equals(Planet.SUN))thePlanet=Sun.getInstance();
            else thePlanet=null;
        }catch(IOException e){
            e.printStackTrace();
        }



    }
}
