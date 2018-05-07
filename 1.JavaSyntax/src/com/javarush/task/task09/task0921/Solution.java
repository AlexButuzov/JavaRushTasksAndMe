package com.javarush.task.task09.task0921;


import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)  );
        ArrayList<Integer> arrayInt = new ArrayList<>();
        try {
            String stroka = "a";
            while (!stroka.equals("")) {
                stroka = reader.readLine();

                arrayInt.add(Integer.parseInt(stroka));

            }

        } catch (NumberFormatException | IIOException exp) {
            for (int counter = 0; counter < arrayInt.size(); counter ++) {
                System.out.println(arrayInt.get(counter));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
