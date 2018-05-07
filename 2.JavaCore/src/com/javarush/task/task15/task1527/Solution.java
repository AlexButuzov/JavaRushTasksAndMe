package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Парсер реквестов
*/

public class Solution {
    private static  String stroka = null;
    private static  String urlParametr = null;
    static HashMap<String,String> parametrsMap = new HashMap <String, String>();

    public static void main(String[] args) {
        //add your code here
        inputUrlString();
        tratslateUrlParametersToHashMap();
        printParametrsMapValue();


    }

    private static void inputUrlString() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        try {
            stroka = reader.readLine();
        } catch (IOException exp) {
            System.out.println(exp.getStackTrace());
        } finally {
            try {
                reader.close();
            } catch (IOException exx) {
                System.out.println(exx.getStackTrace());
            }
        }
    }
    private static void tratslateUrlParametersToHashMap(){
        if (String.valueOf(stroka) != null) {
            stroka.trim();
            urlParametr = String.valueOf(stroka).substring(
                    String.valueOf(stroka).indexOf("?") + 1);
            String subUrlParametr;
            while (urlParametr.length() > 0) {

                subUrlParametr = cutOneParametr();

                translateParametrToHash(subUrlParametr);
            }
            System.out.println();
        }
    }
    private static String cutOneParametr() {
        String subUrlParametr;
        if (urlParametr.indexOf("&") > 0) {
            subUrlParametr = String.valueOf(urlParametr).substring(0,
                    String.valueOf(urlParametr).indexOf("&"));
            urlParametr = String.valueOf(urlParametr).substring(String.valueOf(urlParametr).indexOf("&") + 1);
        } else {
            subUrlParametr = urlParametr;
            urlParametr = "";
        }
        return subUrlParametr;
    }

    private static void translateParametrToHash(String parametr) {
        String key = null;
        String value = null;
        if ( parametr.indexOf("=") > 0) {
            key = String.valueOf(parametr).substring(0,
                    String.valueOf(parametr).indexOf("="));
            value = String.valueOf(parametr).substring(String.valueOf(parametr).indexOf("=") + 1);
        } else key = parametr;
        System.out.print(key + " ");
        parametrsMap.put(key,value);
    }

    private static void printParametrsMapValue() {
        Iterator<Map.Entry<String,String>> iteratorPair = parametrsMap.entrySet().iterator();

           while( iteratorPair.hasNext()) {
               Map.Entry<String,String> pair = iteratorPair.next();
               if ("obj".equals(pair.getKey())
                       && (pair.getValue()!= null)) {

                   try{
                       Double value = Double.parseDouble(pair.getValue());
                       alert(value);
                   } catch (NumberFormatException exp){

                       alert(pair.getValue());
                   }

               }
           }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
