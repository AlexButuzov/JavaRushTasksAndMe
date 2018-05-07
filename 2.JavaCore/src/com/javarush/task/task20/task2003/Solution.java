package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String sourceFileAddress = reader.readLine();
        reader.close();
        FileInputStream fileInputStream = new FileInputStream(sourceFileAddress);
        load(fileInputStream);

    }


    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream));
        Properties tempProperties = new Properties();
        ((Properties) tempProperties).putAll(properties);

       /* for (Map.Entry<String, String> pair : properties.entrySet()) {
            tempProperties.setProperty(pair.getKey(),pair.getValue());
        }*/
        tempProperties.store(writer," = ");
        writer.close();


    }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader( new InputStreamReader(inputStream));
            Properties tempProperties = new Properties();
            tempProperties.load(reader);
            reader.close();
            for (String key : tempProperties.stringPropertyNames()) {
                properties.put(key, tempProperties.getProperty(key));
            }
        }

        public static void main(String[] args) {

        }

}
