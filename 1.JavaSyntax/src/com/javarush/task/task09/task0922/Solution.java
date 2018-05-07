package com.javarush.task.task09.task0922;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
Какое сегодня число?
*/

public class Solution {

    /**
     * 27.02.2018
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in) );

        String dataString = reader.readLine();
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");

        try {
            Date datter = ft.parse(dataString);
            Locale locale = new Locale("en", "EN"); //прописываем локальные настройки, для определения месяцев на английском
            Locale.setDefault(locale);
            System.out.printf("%1$Tb %1$td, %1$tY",datter);

        }catch (ParseException e) {
            System.out.println("Нераспаршена с помощью " + ft);
        }


    }
}
