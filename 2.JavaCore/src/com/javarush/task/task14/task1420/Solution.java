package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        /*String stroka1 = inputLine();
        Integer firstNumberMain = stringToNumber(stroka1);
        String stroka2 = inputLine();
        Integer secondNumberMain = stringToNumber(stroka2);
*/
       // Integer nodNumberMain = nodMethod(firstNumberMain,secondNumberMain);
        //System.out.println(nodNumberMain);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        int b = Integer.parseInt(reader.readLine());

        try{

        if (a <= 0 || b <= 0) { throw new Exception();}
        } finally {
            a=Math.abs(a);
            b=Math.abs(b);
            int nod = nodMethod(a,b);

            System.out.println(nod);
        }


    }
    //}

    public static String inputLine() throws IOException{
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String stroka = reader.readLine();
        while (stroka.equals(null)) {
            stroka = reader.readLine();}


        //reader.close();
        return stroka;
    }

    private static Integer stringToNumber( String stroka) throws Exception{
        Integer numberFromString = null;
        numberFromString = Integer.parseInt(stroka);
        if ((numberFromString == null) || (numberFromString <= 0) ) throw new Exception();
        return  numberFromString;
    }

    private static Integer nodMethod(Integer firstNumber, Integer secondNumber) {
        Integer numberNOD = 0;
        if (firstNumber > secondNumber) {
            numberNOD = secondNumber;
        } else {
            numberNOD = firstNumber;
        }


        while ( (firstNumber % numberNOD != 0) && (secondNumber % numberNOD != 0)) {
            numberNOD--;
        }
        return numberNOD;
    }

}
