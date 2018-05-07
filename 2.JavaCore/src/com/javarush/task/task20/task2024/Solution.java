package com.javarush.task.task20.task2024;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    public Solution (int counter) {
        node = counter;
        edges.add(this);
        if (counter != 0) new Solution((counter -1));
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Solution stratToSerilize = new Solution(4);
        Solution loadedFromSerialize = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(stratToSerilize);
        objectOutputStream.close();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        loadedFromSerialize = (Solution) objectInputStream.readObject();

    }
}
